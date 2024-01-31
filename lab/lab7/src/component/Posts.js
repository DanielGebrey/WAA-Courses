import React, { useState } from 'react';
import Post from './Post';
import PostDetails from './postDetails/PostDetails';
import '../index.css'

const Posts = (props) => {

    const [selectedPost, setSelectedPost] = useState(null);
    const [newTitle, setNewTitle] = useState('');

    const postsList = props.posts.map((post) => (
        <Post
            key={post.id}
            id={post.id}
            Title={post.Title}
            Author={post.Author}
            onClick={() => {
                setSelectedPost(post)
            }}
        />
    ));
    const handleTitleChange = (event) => {
        setNewTitle(event.target.value)
    }

    return (
        <div>

            {postsList}

            {/* <div className='Change'>
                <input type='text' value={newTitle} onChange={handleTitleChange} />
                <button onClick={() => {
                    console.log(posts);
                    posts[0].Title = newTitle;
                    const newPosts = [...posts]
                    setPosts(newPosts);
                }}>Update change</button>
            </div> */}
            {selectedPost && <PostDetails post={selectedPost} />}
        </div>

    );
};

export default Posts;
