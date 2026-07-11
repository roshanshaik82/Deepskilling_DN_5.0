import React, { Component } from "react";

class EventExamples extends Component {
  constructor() {
    super();

    this.state = {
      count: 5
    };
  }

  increment = () => {
    this.setState({
      count: this.state.count + 1
    });
  };

  decrement = () => {
    this.setState({
      count: this.state.count - 1
    });
  };

  sayHello = () => {
    alert("Hello! Member!");
  };

  sayWelcome = (message) => {
    alert(message);
  };

  handleClick = () => {
    alert("I was clicked");
  };

  handleIncrement = () => {
    this.increment();
    this.sayHello();
  };

  render() {
    return (
      <div>
        <h3>{this.state.count}</h3>

        <button onClick={this.handleIncrement}>
          Increment
        </button>

        <br />

        <button onClick={this.decrement}>
          Decrement
        </button>

        <br />

        <button onClick={() => this.sayWelcome("welcome")}>
          Say welcome
        </button>

        <br />

        <button onClick={this.handleClick}>
          Click on me
        </button>
      </div>
    );
  }
}

export default EventExamples;