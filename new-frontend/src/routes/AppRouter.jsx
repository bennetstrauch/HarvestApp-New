import '../App.css'

import {
  Route,
  Routes,
} from "react-router-dom";
import MainPage from "../pages/MainPage";
import CheckAuth from "./CheckAuth";
import Login from "../authentification/Login";
import Register from "../authentification/Register";
import { CropsFieldsProvider } from '../globalStates/CropsFields';
import FinalizeEntry from '../components/newHarvestEntry/FinalizeEntry';
import HarvestLog from '../pages/HarvestLog';


export const Path_HarvestLog = "/harvest-log";
export const Path_ModifyCrops = "/modify-crops";
export const Path_NewEntry = "/new-entry";


function AppRouter() {
  return (

    <Routes>
      {/* Public Routes */}
      <Route path="login" element={<Login />} />
      <Route path="register" element={<Register />} />

      {/* Protected Routes */}
      <Route element={<CheckAuth />}>
        <Route element={<CropsFieldsProvider />}>

          <Route path={Path_NewEntry} element={<MainPage />} />
          <Route path="/" element={<MainPage />} />

          <Route path={Path_NewEntry + "/:cropName"} element={<FinalizeEntry />} />

          <Route path={Path_HarvestLog} element={<HarvestLog />} />
          {/* <Route path={Path_ModifyCrops} element={<ModifyCrops />} /> */}
        </Route>
      </Route>

      {/* # catch page not found */}
      {/* <Route path="*" element={<Missing />} /> */}

    </Routes>

  );
}

export default AppRouter;
