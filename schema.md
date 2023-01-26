# user
- First Name ```String```
- Last Name ```String```
- email ```String```
- username ```String```
- posts ```List<Integer>```
- comments ```List<Integer>```
- postsUpvoted ```List<Integer>```
- postsDownvoted ```List<Integer>```
- commentsUpvoted ```List<Integer>```
- commentsDownvoted ```List<Integer>```

# post
- date_created ```Date```
- date_edited ```Date```
- title ```Text```
- content ```Text```
- upVotes ```Integer```
- downVotes ```Integer```
- userId ```Integer``` | Foreign Key
- comments ```List<Integer>```
- upVotedBy ```List<Integer>```
- downVotedBy ```List<Integer>```

# comment
- date_created ```Date```
- date_edited ```Date```
- content ```Text```
- upVotes ```Integer```
- downVotes ```Integer```
- postId ```Integer``` | Foreign Key
- userId ```Integer``` | Foreign Key
- upVotedBy ```List<Integer>```
- downVotedBy ```List<Integer>```


## RelationShips

### One-One