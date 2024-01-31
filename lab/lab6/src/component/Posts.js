import React, { useState } from 'react';
import Post from './Post';
import PostDetails from './postDetails/PostDetails';
import '../index.css'

const Posts = () => {
    const [posts, setPosts] = useState([
        {
            id: 1,
            Title: 'Happiness',
            Author: 'John',
        },
        {
            id: 2,
            Title: 'MIU',
            Author: 'Dean',
        },
        {
            id: 3,
            Title: 'Enjoy Life',
            Author: 'Jasmine',
        },
    ]);

    const [selectedPost, setSelectedPost] = useState(null);
    const [newTitle, setNewTitle] = useState('');

    const postsList = posts.map((post) => (
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

            <div className='Change'>
                <input type='text' value={newTitle} onChange={handleTitleChange} />
                <button onClick={() => {
                    console.log(posts);
                    posts[0].Title = newTitle;
                    const newPosts = [...posts]
                    setPosts(newPosts);
                }}>Update change</button>
            </div>
            <PostDetails post={selectedPost} />
        </div>

    );
};

export default Posts;
