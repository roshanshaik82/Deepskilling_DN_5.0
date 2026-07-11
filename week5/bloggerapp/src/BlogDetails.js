import React from 'react';

const BlogDetails = (props) => {

    const blogdet = (
        <ul>
            {props.blogs.map((blog) =>
                <div key={blog.id}>
                 <h3>{blog.title}</h3>
                 <h4>{blog.author}</h4>
                 <p>{blog.description}</p>
                </div>
            )}
        </ul>
    );

    return (
    <div className="mystyle1">
        <h1>Blog Details</h1>
        {blogdet}
    </div>
);
};

export default BlogDetails;