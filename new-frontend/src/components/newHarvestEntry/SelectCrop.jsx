import React from 'react'
import { useNavigate } from 'react-router-dom';
import CropButtons from './CropButtons';



const SelectCrop = () => {
  const navigateTo = useNavigate();


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

      <CropButtons />

      <br />

      {/* {modifyCropsButton} */}


    </div>
  )
}

export default SelectCrop