import {RendevouzTable} from "./RendevouzTable";
import {CreateBarber} from "./CreateBarber";

export const Dashboard = () => {
    return (
        <>
            <h1>
                Dashboard
            </h1>
            <div className={'mb-2'}>
                <CreateBarber/>
            </div>
            <div>
                <RendevouzTable />
            </div>
        </>
    )
}