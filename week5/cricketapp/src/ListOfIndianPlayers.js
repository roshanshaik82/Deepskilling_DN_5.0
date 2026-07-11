function ListOfIndianPlayers(props) {

    return (
        <div>
            {
                props.IndianPlayers.map((item, index) => (
                    <li key={index}>
                        Mr. {item}
                    </li>
                ))
            }
        </div>
    );
}
export default ListOfIndianPlayers;