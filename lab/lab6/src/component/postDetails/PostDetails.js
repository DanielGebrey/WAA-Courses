// PostDetails.js
import React from 'react';

const PostDetails = ({ post }) => {
    if (!post) {
        return null;
    }

    return (
        <div className='PostDetails'>
            <h2>Post Details</h2>
            <p>ID: {post.id}</p>
            <p>Title: {post.Title}</p>
            <p>Author: {post.Author}</p>
        </div>
    );
};

export default PostDetails;
