package com.self.vehicleregistration.api;

public class TestConstants {

    static final String PAYLOAD_ONLY_FORD_AND_GM = """
            {
                "vehicles": [
                    {
                        "VIN": "47364677",
                        "manufacturer": "FORD",
                        "bay_number": 50
                    },
                    {
                        "VIN": "4872647",
                        "manufacturer": "GM",
                        "bay_number": 20
                    }
                ]
            }
            """;

    static final String PAYLOAD_WITH_VW = """
            {
                "vehicles": [
                    {
                        "VIN": "37456",
                        "manufacturer": "VW",
                        "bay_number": 50
                    },
                    {
                        "VIN": "47475",
                        "manufacturer": "FORD",
                        "bay_number": 20
                    }
                ]
            }
            """;

    static final String PAYLOAD_WITH_BAY_OVER_100 = """
            {
                "vehicles": [
                    {
                        "VIN": "4837",
                        "manufacturer": "GM",
                        "bay_number": 150
                    },
                    {
                        "VIN": "12563",
                        "manufacturer": "FORD",
                        "bay_number": 1
                    }
                ]
            }
            """;

    static final String PAYLOAD_WITHOUT_BAY_NUMBER = """
            {
                "vehicles": [
                    {
                        "VIN": "13457",
                        "manufacturer": "FORD"
                    },
                    {
                        "VIN": "3847",
                        "manufacturer": "GM"
                    }
                ]
            }
            """;


    static final String PAYLOAD_CORRECT = """
            {
                "vehicles": [
                    {
                        "VIN": "1234",
                        "manufacturer": "GM",
                        "bay_number": 50
                    },
                    {
                         "VIN": "12",
                         "manufacturer": "FORD",
                         "bay_number": 1
                        }
                ]
            }
            """;

    static final String PAYLOAD_WRONG = """
            {
                "vehicles": [
                    {
                          "VIN": "1234",
                          "manufacturer": "GM",
                          "bay_number": 200
                    },
                    {
                         "VIN": "12",
                         "manufacturer": "",
                         "bay_number": 1
                    }
            ]
            }
            """;
}
