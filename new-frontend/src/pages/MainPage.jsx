import React from 'react'
import SelectCrop from '../components/newHarvestEntry/SelectCrop';
import { useNavigate } from 'react-router-dom';
import { Path_HarvestLog } from '../routes/AppRouter';

const MainPage = () => {
  console.log("RENDER MainPage");

  const navigate = useNavigate();


  // global navigateToButton constant ##
  const harvestLog_Button = (
    <button onClick={() => navigate(Path_HarvestLog)}> Harvest Log </button>
  );

  const head = (
    <header>
      {harvestLog_Button}
      {/* {modifyDate_Button}
      {logout_Button} */}
    </header>
  );

  return (
    <div className="mainPage"> MainPage
      {head}

      <br />


      <SelectCrop />


    </div>
  );
}

export default MainPage