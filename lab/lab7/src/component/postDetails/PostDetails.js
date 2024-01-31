// PostDetails.js
import React from 'react';
import axios from 'axios';
import { useState } from 'react';
import { useEffect } from 'react';


const PostDetails = ({ post }) => {
    const [postDetails, setPostDetails] = useState([]);

    const fetchPost = (id) => {
        axios.get(`http://localhost:8080/api/v1/posts/${id}`)
            .then(response => setPostDetails(response.data))
            .catch(error => console.log(error.message));
    };

    useEffect(() => {
        fetchPost(post.id);
    }, [post]);

    if (!post) {
        return null;
    }

    return (
        <div className='PostDetails'>
            <h2>Post Details</h2>
            <p>ID: {post.id}</p>
            <p>Title: {post.title}</p>
            <p>Author: {post.author}</p>
        </div>
    );
};

export default PostDetails;
