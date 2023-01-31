// package com.kalyan.demo.service;

// import java.util.List;

// import org.springframework.data.jpa.repository.Query;
// import org.springframework.stereotype.Service;

// import com.kalyan.demo.dao.CommentRepository;
// import com.kalyan.demo.dao.PostRepository;
// import com.kalyan.demo.dao.UserRepository;
// import com.kalyan.demo.entity.Comment;
// import com.kalyan.demo.entity.Post;

// import jakarta.persistence.EntityManager;

// @Service
// public class VoteServiceImpl implements VoteService {

//     private UserRepository userRepository;
//     private PostRepository postRepository;
//     private CommentRepository commentRepository;
//     private EntityManager entityManager;
//     @Override
//     public List<Comment> postsUpvoted() {
//         Query query = this.entityManager.createNativeQuery("SELECT * FROM upvoted_posts GROUP BY post_id ")
//     }
    
// }
