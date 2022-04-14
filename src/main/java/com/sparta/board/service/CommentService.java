package com.sparta.board.service;


import com.sparta.board.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Transactional
    public void addComment(Long post_id, CommentRequestDto requestDto) {
        Optional<Post> result = Optional.ofNullable(postRepository.findById(post_id).orElseThrow(NullPointerException::new));
        Comment comment = Comment.builder()
                .contents(requestDto.getContents())
                .username(requestDto.getUsername())
                .build();
        commentRepository.save(comment);
        result.get().addComment(comment);
    }

    @Transactional
    public Long updateComment(Long commentId,CommentRequestDto requestDto){
        Comment comment=commentRepository.findById(commentId).orElseThrow(
                ()->new NullPointerException("해당 아이디가 없습니다.")
        );
        comment.update(requestDto);
        return commentId;
    }
}
