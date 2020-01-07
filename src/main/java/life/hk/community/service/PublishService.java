package life.hk.community.service;

import life.hk.community.dto.PaginationDTO;
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


    public PaginationDTO list(Integer page, Integer size) {


        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = publishMapper.count();
        paginationDTO.setPagination(totalCount, page, size);

        if (page < 1) {
            page = 1;
        }
        if (page > paginationDTO.getTotalPage()) {
            page = paginationDTO.getTotalPage();
        }

        // size*(page-1)

        Integer offset = size * (page - 1);
        List<Publish> publishes = publishMapper.list(offset, size);
        List<PublishDTO> publishDTOList = new ArrayList<>();

        for (Publish publish : publishes) {
            User user = userMapper.findById(publish.getCreator());
            PublishDTO publishDTO = new PublishDTO();
            BeanUtils.copyProperties(publish, publishDTO);
            publishDTO.setUser(user);
            publishDTOList.add(publishDTO);
        }
        paginationDTO.setPublishDTOS(publishDTOList);
        return paginationDTO;
    }

    public PaginationDTO list(Integer userId, Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = publishMapper.count();
        paginationDTO.setPagination(totalCount, page, size);

        if (page < 1) {
            page = 1;
        }
        if (page > paginationDTO.getTotalPage()) {
            page = paginationDTO.getTotalPage();
        }

        // size*(page-1)

        Integer offset = size * (page - 1);
        List<Publish> publishes = publishMapper.list(userId.offset, size);
        List<PublishDTO> publishDTOList = new ArrayList<>();

        for (Publish publish : publishes) {
            User user = userMapper.findById(publish.getCreator());
            PublishDTO publishDTO = new PublishDTO();
            BeanUtils.copyProperties(publish, publishDTO);
            publishDTO.setUser(user);
            publishDTOList.add(publishDTO);
        }
        paginationDTO.setPublishDTOS(publishDTOList);
        return paginationDTO;
    }
    }
}
