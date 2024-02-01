import React, { useEffect, useState } from 'react'
import Posts from '../component/Posts'
import PostDetails from '../component/postDetails/PostDetails'
import { fetchService } from '../service/FetchService'

const Dashboard = () => {
  const [posts, setPosts] = useState([]);

  const loadPost = async () => {
    await fetchService.get('posts').then(data => setPosts(data));
    await fetchService.remove('posts').then(data => setPosts(data));
  }
  useEffect(() => { loadPost() }, [])
  return (
    <div>
      <Posts posts={posts} />
      {/* <PostDetails /> */}
    </div>
  )
}

export default Dashboard
