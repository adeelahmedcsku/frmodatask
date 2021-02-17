# frmodatask
## Interview task from frmoda

1. Download the project or clone it in your local envoirment.
2. Open project using intellijIdea is recommended.
3. You must have java development envoirment and Maven in your system.
4. Run project as spring boot project.
5. Open the Postman and make the following hits:
  
  To join the data in file and the sku provided through the api.
  
  1/A) Please try to call the end-point "myDeveloper" at the URL (https://europe-west6-frmoda-apis-287409.cloudfunctions.net/myDeveloper). For the sake of the exercise, there is no auth.

  1/B) Please store data from json to a correct collector/variable and compile, eventually, missing data (hard-coded it's okay for the sake of the exercise)
   
   1/C) Please load the file attached and read it directly from your code; then join file data with API data and enrich for each sku; Pay attention to sizes: every product can have more than 1 size;
   
   **localhost:8080/joinDataSet**
   
   2/A) Please return in some ways the list of most selled sku, based on the column stock

   **localhost:8080/getMostSellSku**
  
3/A) Please normalize automatically datas returning the sku without the "color"; colors are in Italian and are "BIANCO", "NERO", "ROSSO", "BLU" and "AZZURRO"

**localhost:8080/getStocksWithOutColor**


