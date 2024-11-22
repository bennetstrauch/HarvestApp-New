// Calculate based on timeframe and offset
export function calculateDateRange(timeframe, offset) {
  const now = new Date();
  let endDate = new Date();
  endDate.setDate(now.getDate() + offset);

  let startDate = new Date(endDate);
  startDate.setDate(endDate.getDate() - timeframe);

  // Format dates to "YYYY-MM-DD"
  const formatDate = (date) => {
    return date.toISOString().split("T")[0]; 
  };

  startDate = formatDate(startDate);
  endDate = formatDate(endDate);

  console.log(
    "Date now ",
    now,
    "Start date: ",
    startDate,
    "End date: ",
    endDate
  );

  return { startDate, endDate };
}


export function getCurrentDate() {
  const currentDate = new Date().toJSON().slice(0, 10);
  return currentDate;
}


// ## mock for development
export function getUserId() {
    return 1;
}
  

export function mapToHTML(listToMap, htmlElement) {
    let html = "-";
  
    if (listToMap.length !== 0) {
      try {
        html = listToMap.map((element) => htmlElement(element));
      } catch (error) {
        console.error("Error in mapToHTML: ", error);
        html = "Error in displaying the fields";
      }
    }
  
    return html;
  }
