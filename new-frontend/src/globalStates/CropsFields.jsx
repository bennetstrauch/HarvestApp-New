import { Outlet } from "react-router-dom";
import { get } from "../service/fetchService";
import { createContext, useEffect, useRef, useState } from "react";


export const CropsFieldsContext = createContext();

export const CropsFieldsProvider = () => {
    console.log("RENDER CropsFieldsProvider");

    const harvestedFields = useRef([]);


    const [crops, setCrops] = useState( [] );
    const [fields, setFields] = useState( [] );

    // take care about rerenders!##
    //#abstraction possible, fields = {name: "harvest-field", values: [...]}
    useEffect(() => {
        get("crops")
            .then((data) => {
                setCrops(data)
                console.log("data from fetched crops:", data)
            });

        get("harvest-fields")
            .then((data) => {
                setFields(data)
                console.log("data from fetched fields:", data)
            });

    }, []);
    

    

    return (
        <CropsFieldsContext.Provider value={{ crops, fields, harvestedFields }}>
            CropsFieldsContext
            <Outlet />
        </CropsFieldsContext.Provider>
    );
}

