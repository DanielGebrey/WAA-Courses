const Post = (props) => {
    return (
        <div className="Content" onClick={props.onClick}>
            <h1>{props.id}</h1>
            <h3>{props.Title}</h3>
            <p>{props.Author}</p>
        </div>
    );
}

export default Post;
