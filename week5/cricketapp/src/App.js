import ListOfPlayers from "./ListOfPlayers";
import ScoreBelow70 from "./ScoreBelow70";

import ListOfIndianPlayers from "./ListOfIndianPlayers";

import {
  IndianPlayers,
  OddPlayers,
  EvenPlayers
} from "./IndianPlayers";

function App() {

  const players = [
    { name: "Jack", score: 50 },
    { name: "Michael", score: 70 },
    { name: "John", score: 40 },
    { name: "Ann", score: 61 },
    { name: "Elisabeth", score: 61 },
    { name: "Sachin", score: 95 },
    { name: "Dhoni", score: 100 },
    { name: "Virat", score: 84 },
    { name: "Jadeja", score: 64 },
    { name: "Raina", score: 75 },
    { name: "Rohit", score: 80 }
  ];
  var flag = false;
  if (flag === true) {
    return (
      <div>
        <h1>List of Players</h1>
        <ListOfPlayers players={players} />
        <hr />
        <h1>List of Players having Scores Less than 70</h1>
        <ScoreBelow70 players={players} />
      </div>
    );
  } else {
    return (
      <div>
        <div>
          <h1>Indian Team</h1>
          <h1>Odd Players</h1>
          {OddPlayers(IndianPlayers)}
          <hr />
          <h1>Even Players</h1>
          {EvenPlayers(IndianPlayers)}
        </div>
        <hr />
        <div>
          <h1>List of Indian Players Merged:</h1>
          <ListOfIndianPlayers IndianPlayers={IndianPlayers} />
        </div>
      </div>
    );
  }
}
export default App;