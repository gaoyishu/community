package life.hk.community.service;

import life.hk.community.dto.PublishDTO;
import life.hk.community.mapper.PublishMapper;
import life.hk.community.mapper.UserMapper;
import life.hk.community.model.Publish;
import life.hk.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoyishu
 * @date 2019/12/25 18:15
 * service 页面和服务器数据交互层
 **/

@Service
public class PublishService {

    @Autowired
    private PublishMapper publishMapper;

    @Autowired
    private UserMapper userMapper;


    public List<PublishDTO> list() {

        List<Publish> publishes = publishMapper.list();
        List<PublishDTO> publishDTOList = new ArrayList<>();
        for (Publish publish : publishes) {
            User user = userMapper.findById(publish.getCreator());
            PublishDTO publishDTO = new PublishDTO();
            BeanUtils.copyProperties(publish, publishDTO);
            publishDTO.setUser(user);
            publishDTOList.add(publishDTO);
        }
        return publishDTOList;
    }
}
