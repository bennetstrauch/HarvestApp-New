import React, { useRef } from 'react'
import { useLocation, useNavigate, useParams } from 'react-router-dom';

const FinalizeEntry = () => {
    
    let selectedCrop = useLocation().state.selectedCrop;
    console.log("selectedCrop", selectedCrop);

    // in redux?
    const navigateTo = useNavigate();
   
    const harvestedAmount = useRef(0.0);
    const harvestedFields = useRef([])

    function prepareEntry(){
        let newEntry = {
          harvestDate: harvestDate2.current.value,
          cropName: selectedCrop,
          harvestedAmount: harvestedAmount.current.value,
          harvestedFields: harvestedFields.current.value
        }
      }


    
      // async function postHarvestEntryAndSetLatestEntry() {
      //   const addedEntryId = await postHarvestEntry(harvestEntryObject);
      //   console.log("addedEntryId", addedEntryId);
    
      //   const addedEntry = await getHarvestEntry(addedEntryId);
      //   setLatestEntry(addedEntry);
      //   console.log("added Entry", addedEntry);
      // }

      
      // const handleEntrySubmission = () => {
      //   postHarvestEntryAndSetLatestEntry();
      //   goBack();
      // };

      // const submitEntry_Button = (
      //   <button onClick={handleEntrySubmission}>Submit</button>
      // );
      // //#
      // const modifyFieldsButton = (
      //   <button onClick={navigateTo(Path_ModifyCrops)}>Modify Fields</button>
      // );

    return (
        <div>finalizeEntry

            {/* <EnterAmountAndField
                {...{harvestedAmount2: harvestedAmount, harvestedFields, selectedCrop}}
            />

            <br />
            {submitEntry_Button}
            {modifyFieldsButton} */}

        </div>
    )
}

export default FinalizeEntry