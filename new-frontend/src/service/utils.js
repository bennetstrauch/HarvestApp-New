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
