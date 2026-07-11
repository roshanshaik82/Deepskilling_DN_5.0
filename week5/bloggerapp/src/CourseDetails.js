import React from 'react';

const CourseDetails = (props) => {

    const coursedet = (
        <ul>
            {props.courses.map((course) =>
                <div key={course.id}>
                    <h3>{course.cname}</h3>
                    <h4>{course.date}</h4>
                </div>
            )}
        </ul>
    );

    return (
    <div className="st2">
        <h1>Course Details</h1>
        {coursedet}
    </div>
);
};

export default CourseDetails;