//REFACTOR!!!#
import { useContext } from "react";

import { mapToHTML } from "../../service/utils";
import { CropsFieldsContext } from "../../globalStates/CropsFields";
import { useNavigate } from "react-router-dom";
import { Path_NewEntry } from "../../routes/AppRouter";

function CropButtons() {
  const navigate = useNavigate();
  const crops = useContext(CropsFieldsContext);



  //#bessere Namen für Handle click function
  const handleClick = (crop) => {
    console.log("selectedCrop:", crop.name);

    // naviagte to path and pass selected crop as state
    navigate(Path_NewEntry + "/" + crop.name,
      { state: { selectedCrop: crop } }
    );
  };


  return (
    <div>
      <p> Please select crop: </p>

      {mapToHTML(crops, (crop) => (
        <button onClick={() => handleClick(crop)}> {crop.name} </button>
      ))}
    </div>
  );
}

export default CropButtons;
