package com.yoke;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

//@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() throws InterruptedException {

		for (int i = 2; i <= 30001; i++){
			Thread thread = new Thread(new GrabRedPacketTask(i));
			thread.setName("user-" + i);
			thread.start();
			thread.join();
		}

	}

	private class GrabRedPacketTask implements Runnable{

		private Integer userId;

		public GrabRedPacketTask(Integer userId){
			this.userId = userId;
		}

		@Override
		public void run() {
			CloseableHttpResponse response = null;
			try(CloseableHttpClient client = HttpClientBuilder.create().build()){
				HttpPost post = new HttpPost("http://127.0.0.1:8080/red-packet/grab?rpId=1&userId=" +userId);
				post.setHeader("Content-Type", "application/json;charset=utf8");

				response = client.execute(post);
				HttpEntity entity = response.getEntity();
				System.out.println("响应结果：" + EntityUtils.toString(entity, "utf-8"));
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if (response != null){
					try {
						response.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
