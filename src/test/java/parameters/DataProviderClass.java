package parameters;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name = "SingleValue")
    public Object[][] storeSingleValue() {
        return new Object[][] {
                {"Emrul"},
                {"Rifat"},
                {"Shajib"}
        };
    }

    @DataProvider(name = "MultipleValue")
    public Object[][] storeMultipleValues() {
        return new Object[][] {
                {"Emrul", "Sydney", 21423},
                {"Rifat", "Florida", 12425},
                {"Shajib", "New York", 23423}
        };
    }

    @DataProvider(name = "RealApr")
    public Object[][] RealAprData() {
        return new Object[][] {
                {"200000", "15000", "3", "3.130%"},
                {"250000", "17000", "3.2", "3.321%"}
        };
    }
}
