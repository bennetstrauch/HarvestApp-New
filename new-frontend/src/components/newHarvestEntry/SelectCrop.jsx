import React from 'react'
import { useNavigate } from 'react-router-dom';
import CropButtons from './CropButtons';



const SelectCrop = () => {
  console.log("RENDER SelectCrop");

  // const modifyCropsButton = (
  //   <button
  //     onClick={navigateTo(Path_ModifyCrops)}>
  //     Modify Crops
  //   </button>
  // );


  return (
    <div>NewEntry
      {/* <DisplayLatestEntry/> */}

      <br />

      <p> Please select crop: </p>
      <CropButtons />

      <br />

      {/* {modifyCropsButton} */}


    </div>
  )
}

export default SelectCrop