package Assignment.Test;

import Assignment.Controller.FileController;
import Assignment.Controller.TableProductsController;
import Assignment.Model.ProductsModel;
import Assignment.Test.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CalculatorTest {
    private Calculator objCalcUnderTest;

    @BeforeEach
    public void setUp() {
//Arrange
        objCalcUnderTest = new Calculator();
    }

    @Test
    public void testAdd() {
        int a = 15;
        int b = 20;
        int expectedResult = 35;
//Act
        long result = objCalcUnderTest.add(a, b);
//Assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testSubtract() {
        int a = 25;
        int b = 20;
        int expectedResult = 5;
        long result = objCalcUnderTest.subtract(a, b);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testMultiply() {
        int a = 10;
        int b = 25;
        long expectedResult = 250;
        long result = objCalcUnderTest.multiply(a, b);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testDivide() {
        int a = 56;
        int b = 10;
        double expectedResult = 5.6;
        double result = objCalcUnderTest.divide(a, b);
        Assertions.assertEquals(expectedResult, result, 0.00005);
    }

    @Test
    public void testDivideByZero() {
        int a = 15;
        int b = 0;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    objCalcUnderTest.divide(a, b);
                }
        );
    }

//    @Test
//    public void testAddCan(){
//        CandidateManager m = new CandidateManager("");
//        List<Candidate> lstOld = (List<Candidate>)
//                XFile.readObject("src/Application/candidate.dat");
//        int s = lstOld.size();
//        Candidate c = new Candidate(
//                "GCC02065", "Huỳnh",
//                Double.parseDouble("9.0"),
//                Double.parseDouble("8.0"),
//                Double.parseDouble("7.0"),
//                false,
//                "2000-01-18");
//        lstOld.add(c);
//        int expected = s + 1;
//        Assertions.assertEquals(expected, lstOld.size());
//
//    }

    @Test
    public void checkProductsModelNotNull() {

        String file = "src/Assignment/Model/fProductModel.dat";

        List<ProductsModel> tbProductsModelList;

        tbProductsModelList = (List<ProductsModel>) FileController.readObject(file);

        int beforeSizeTbProductsModelList = tbProductsModelList.size();

        if (tbProductsModelList == null || tbProductsModelList.size() == 0) {
            tbProductsModelList = new ArrayList<>();
            tbProductsModelList.add(new ProductsModel("TCH180120", "Exciter 150", "Blue", "Underbone",
                    "Yamaha", "Single Cylinder", 150.0, 4.0, 138.0,
                    100, 52000000.0, "2022-08-27"));

            FileController.writeObject(file, tbProductsModelList);

        }

        int afterSizeTbProductsModelList = beforeSizeTbProductsModelList;

        Assertions.assertEquals(afterSizeTbProductsModelList, tbProductsModelList.size());

    }

    @Test
    public void checkProductsModelNull() {

        String file = "src/Assignment/Test/fProductModelNull.dat";

        List<ProductsModel> tbProductsModelList;

        tbProductsModelList = (List<ProductsModel>) FileController.readObject(file);


        if (tbProductsModelList == null || tbProductsModelList.size() == 0) {
            tbProductsModelList = new ArrayList<>();
            tbProductsModelList.add(new ProductsModel("TCH180120", "Exciter 150", "Blue", "Underbone",
                    "Yamaha", "Single Cylinder", 150.0, 4.0, 138.0,
                    100, 52000000.0, "2022-08-27"));

            FileController.writeObject(file, tbProductsModelList);

        }

        int getSizeTbProductsModelList = tbProductsModelList.size();

        int expectedResult = 1;

        Assertions.assertEquals(getSizeTbProductsModelList, expectedResult);

    }

    @Test
    public void checkDuplicationNo() {

        String file = "src/Assignment/Model/fProductModel.dat";

        List<ProductsModel> tbProductsModelList;

        tbProductsModelList = (List<ProductsModel>) FileController.readObject(file);

        boolean existed = false;

        for (int i = 0; i < tbProductsModelList.size(); i++) {

            String checkNo = tbProductsModelList.get(i).getNo();

            String existedNo = "TCH180120";

            if (existedNo.equals(checkNo)) {

                existed = true;
                return;
            }
        }

        boolean expectedResult = true;

        Assertions.assertEquals(expectedResult, existed);
    }


    @Test
    public void checkProductsForNoDuplicates() {

        String file = "src/Assignment/Model/fProductModel.dat";

        List<ProductsModel> tbProductsModelList;

        tbProductsModelList = (List<ProductsModel>) FileController.readObject(file);

        boolean existed = false;

        for (int i = 0; i < tbProductsModelList.size(); i++) {

            String checkNo = tbProductsModelList.get(i).getNo();

            String existedNo = "TCH180140";

            if (existedNo.equals(checkNo)) {

                existed = true;
                return;
            }
        }

        boolean expectedResult = false;

        Assertions.assertEquals(expectedResult, existed);
    }

    @Test
    public void checkProductsModelSearching() {

        String file = "src/Assignment/Model/fProductModel.dat";

        List<ProductsModel> tbProductsModelList;

        //Have 2 BMW
        String text = "bMw";

        String regex = ".*" + text + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);


        tbProductsModelList = (List<ProductsModel>) FileController.readObject(file);

        int countModel = 0;

        for (int i = 0; i < tbProductsModelList.size(); i++) {

            String elementsName = tbProductsModelList.get(i).getModel();

            Matcher matcher = pattern.matcher(elementsName);

            if (matcher.matches()) {

                countModel++;
            }
        }

        int expectedResult = 2;

        Assertions.assertEquals(expectedResult, countModel);
    }

    @Test
    public void checkProductsColorSearching() {

        String file = "src/Assignment/Model/fProductModel.dat";

        List<ProductsModel> tbProductsModelList;

        //Have 4 Red
        String text = "re";

        String regex = ".*" + text + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);


        tbProductsModelList = (List<ProductsModel>) FileController.readObject(file);

        int countColor = 0;

        for (int i = 0; i < tbProductsModelList.size(); i++) {

            String elementsName = tbProductsModelList.get(i).getColor();

            Matcher matcher = pattern.matcher(elementsName);

            if (matcher.matches()) {

                countColor++;
            }
        }

        int expectedResult = 4  ;

        Assertions.assertEquals(expectedResult, countColor);
    }

    @Test
    public void checkProductsMakeSearching() {

        String file = "src/Assignment/Model/fProductModel.dat";

        List<ProductsModel> tbProductsModelList;

        //Have 2 BMW
        String text = "bm";

        String regex = ".*" + text + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);


        tbProductsModelList = (List<ProductsModel>) FileController.readObject(file);

        int countMake = 0;

        for (int i = 0; i < tbProductsModelList.size(); i++) {

            String elementsName = tbProductsModelList.get(i).getMake();

            Matcher matcher = pattern.matcher(elementsName);

            if (matcher.matches()) {

                countMake++;
            }
        }

        int expectedResult = 2  ;

        Assertions.assertEquals(expectedResult, countMake);
    }


}

