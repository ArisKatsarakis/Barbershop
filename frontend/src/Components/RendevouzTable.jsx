


export const RendevouzTable = () => {
    const ravdevouz = [
        {
            customer: "Aris Katsarakis",
            time: "20:00",
            type: "Mallia",
        },
        {
            customer: "George Katsarakis",
            time: "20:30",
            type: "Mousia",
        }
    ];
    return (
        <>
            <table className={'table table-light'}>
                <thead>
                     <tr>
                         <th>
                             Time
                         </th>
                         <th>
                             Customer
                         </th>
                         <th>
                             Haircut Type
                         </th>
                     </tr>
                </thead>
                <tbody>
                {ravdevouz.map(
                    rand =>
                        <tr>
                            <th scope={'row'}>
                                {rand.time}
                            </th>
                            <td>
                                {rand.customer}
                            </td>
                            <td>
                                {rand.type}
                            </td>
                        </tr>
                )}
                </tbody>
            </table>

        </>
    )
}