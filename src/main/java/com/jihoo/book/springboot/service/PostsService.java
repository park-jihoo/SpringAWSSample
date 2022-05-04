package com.jihoo.book.springboot.service;

import com.jihoo.book.springboot.domain.posts.Posts;
import com.jihoo.book.springboot.domain.posts.PostsRepository;
import com.jihoo.book.springboot.web.dto.PostsResponseDto;
import com.jihoo.book.springboot.web.dto.PostsSaveRequestDto;
import com.jihoo.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor //생성자로 Bean 객체를 주입받는 방법이 Autowired와 같은데, 이 때 생성자가 여기서 해결됨
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        System.out.println(requestDto.toEntity().getId());
        System.out.println(requestDto.toEntity().getTitle());
        System.out.println(requestDto.toEntity().getContent());
        System.out.println(requestDto.toEntity().getAuthor());

        return postsRepository.save(requestDto.toEntity()).getId();
    }


    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostsResponseDto(entity);
    }
}
