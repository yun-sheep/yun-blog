package com.yun.backgroundmanagement.common.strategy.impl;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import com.yun.backgroundmanagement.common.config.CosProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.region.Region;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description Cos上传策略(真正实现上传的地方）
 * @auther j2-yizhiyang
 * @date 2023/5/2 15:55
 */
@Slf4j
@Service("CosUploadStrategyImpl")
public class CosUploadStrategyImpl extends AbstractUploadImpl {
    @Autowired
    CosProperties cosProperties;


    @Override
    public Boolean exists(String filePath) {
        return getCosClient().doesObjectExist(cosProperties.getBucketName(),filePath);
    }

    @Override
    public void upload(String path, String fileName, InputStream inputStream) throws IOException {
        COSClient cosClient = getCosClient();
        try {
            ObjectMetadata objectMetadata = new ObjectMetadata();
            // 上传的流如果能够获取准确的流长度，则推荐一定填写 content-length
            objectMetadata.setContentLength(inputStream.available());
            // 调用cos方法上传
            cosClient.putObject(cosProperties.getBucketName(), path + fileName, inputStream, objectMetadata);
        }catch (CosServiceException e){
            log.error("Error Message:" + e.getErrorMessage());
            log.error("Error Code:" + e.getErrorCode());
            log.info("Request ID:" + e.getRequestId());
        }catch (CosClientException e){
            log.error("Caught an CosClientException, Error Message:" + e.getMessage());
        }catch (IOException e){
            log.error("Caught an IOException, Error Message:" + e.getMessage());
        }finally {
            //一定要记得关闭流，无论是什么流！！！！
            cosClient.shutdown();
        }
    }

    @Override
    public String getFileAccessUrl(String filePath) {
        return cosProperties.getUrl();
    }
    /**
     * 获取cosClient
     *
     * @return {@link COSClient} cosClient
     */
    private COSClient getCosClient(){
        // 1 初始化用户身份信息（secretId, secretKey）,
        String secretId = cosProperties.getSecretId();
        String secretKey  = cosProperties.getSecretKey();
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        //2、设置 bucket 的地域
        Region region = new Region(cosProperties.getRegion());
        ClientConfig clientConfig = new ClientConfig(region);
        //3、请求所使用的协议，使用的是https
        clientConfig.setHttpProtocol(HttpProtocol.https);
        // 4、生成 cos 客户端。
        return new COSClient(cred, clientConfig);
    }

}
