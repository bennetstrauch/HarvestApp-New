import { Outlet } from "react-router-dom";
import { get } from "../service/fetchService";
import { createContext, useEffect, useState } from "react";


export const CropsFieldsContext = createContext();

export const CropsFieldsProvider = () => {

    const [crops, setCrops] = useState( [] );

    useEffect(() => {
        get("crops")
            .then((data) => {
                setCrops(data)
                console.log("data from fetched crops:", data)
            });

    }, []);
    

    

    return (
        <CropsFieldsContext.Provider value={crops}>
            CropsFieldsContext
            <Outlet />
        </CropsFieldsContext.Provider>
    );
}

