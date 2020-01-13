package life.hk.community.provider;

import com.alibaba.fastjson.JSON;
import life.hk.community.dto.AccessTokenDTO;
import life.hk.community.model.UserInfo;
import okhttp3.*;
import org.springframework.stereotype.Component;

/**
 * User: gaoyishu
 * Date: 2019/11/28
 * Time: 23:48
 */
@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];
            System.out.println(token);
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public UserInfo getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            // command alt v
            UserInfo userInfo = JSON.parseObject(string, UserInfo.class);
            return userInfo;
        } catch (Exception e) {
        }
        return null;
    }
}

