
function QuantityInput({
  harvestedQuantity,
  harvestedCrop,
}) {
  const cropMeasureUnit = harvestedCrop.measureUnit;
  const measureUnitCanBeDecimalNumber =
    cropMeasureUnit.type == 'WEIGHT' ? true : false; //#

  

  const QuantityInput = (
    <input
    ref={harvestedQuantity}
      type="number"
      step={measureUnitCanBeDecimalNumber ? "any" : "number"} // Allow decimals when needed
      name="quantity"
      placeholder={`in ${cropMeasureUnit.name}`}
    />
  );  


  return (
    <div className="QuantityInput">

      Enter Quantity: &nbsp;
      {QuantityInput}
      <br />  <br />
      
    </div>
  );
}

export default QuantityInput;
