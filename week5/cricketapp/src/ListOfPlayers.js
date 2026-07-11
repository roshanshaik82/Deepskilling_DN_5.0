function ListOfPlayers(props) {
    return (
        <div>
            {
                props.players.map((item, index) => (
                    <li key={index}>
                        Mr. {item.name}
                        <span> {item.score}</span>
                    </li>
                ))
            }
        </div>
    );
}
export default ListOfPlayers;