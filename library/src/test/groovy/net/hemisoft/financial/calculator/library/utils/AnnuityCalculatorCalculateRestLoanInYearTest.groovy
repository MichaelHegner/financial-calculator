package net.hemisoft.financial.calculator.library.utils

import static org.assertj.core.api.Assertions.assertThat
import static org.assertj.core.api.Assertions.offset
import static org.junit.Assert.*

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized.class)
class AnnuityCalculatorCalculateRestLoanInYearTest {
    def capital, interest, redemption, specialRedemption, endOfYear, expected
    
    
    public AnnuityCalculatorCalculateRestLoanInYearTest(capital, interest, redemption, specialRedemption, endOfYear, expected) {
        this.capital = capital
        this.interest = interest
        this.redemption = redemption
        this.specialRedemption = specialRedemption
        this.endOfYear = endOfYear
        this.expected = expected
    }

    @Parameters static cases() {
        [
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      1.0,           0.0,                 0.0,          0,          0.0d],
            [-100.0d,      1.0,           0.0,                 0.0,          1,          0.0d],
            [-100.0d,      1.0,           0.0,                 0.0,          10,         0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      1.0,           0.0,                 1.0,          0,          0.0d],
            [-100.0d,      1.0,           0.0,                 1.0,          1,          0.0d],
            [-100.0d,      1.0,           0.0,                 1.0,          10,         0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      1.0,           0.0,                 10.0,         0,          0.0d],
            [-100.0d,      1.0,           0.0,                10.0,          1,          0.0d],
            [-100.0d,      1.0,           0.0,                10.0,          10,         0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      1.0,           1.0,                0.0,          0,           0.0d],
            [-100.0d,      1.0,           1.0,                0.0,          1,           0.0d],
            [-100.0d,      1.0,           1.0,                0.0,          10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      1.0,           1.0,                1.0,          0,           0.0d],
            [-100.0d,      1.0,           1.0,                1.0,          1,           0.0d],
            [-100.0d,      1.0,           1.0,                1.0,          10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      1.0,           1.0,                10.0,         0,           0.0d],
            [-100.0d,      1.0,           1.0,                10.0,         1,           0.0d],
            [-100.0d,      1.0,           1.0,                10.0,         10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      1.0,           10.0,               0.0,          0,           0.0d],
            [-100.0d,      1.0,           10.0,               0.0,          1,           0.0d],
            [-100.0d,      1.0,           10.0,               0.0,          10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      1.0,           10.0,               1.0,          0,           0.0d],
            [-100.0d,      1.0,           10.0,               1.0,          1,           0.0d],
            [-100.0d,      1.0,           10.0,               1.0,          10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      1.0,           10.0,            10.0,            0,           0.0d],
            [-100.0d,      1.0,           10.0,            10.0,            1,           0.0d],
            [-100.0d,      1.0,           10.0,            10.0,            10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      10.0,           0.0,            0.0,             0,           0.0d],
            [-100.0d,      10.0,           0.0,            0.0,             1,           0.0d],
            [-100.0d,      10.0,           0.0,            0.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      10.0,           0.0,            1.0,             0,           0.0d],
            [-100.0d,      10.0,           0.0,            1.0,             1,           0.0d],
            [-100.0d,      10.0,           0.0,            1.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      10.0,           0.0,            10.0,            0,           0.0d],
            [-100.0d,      10.0,           0.0,            10.0,            1,           0.0d],
            [-100.0d,      10.0,           0.0,            10.0,            10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      10.0,           1.0,            0.0,             0,           0.0d],
            [-100.0d,      10.0,           1.0,            0.0,             1,           0.0d],
            [-100.0d,      10.0,           1.0,            0.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      10.0,           1.0,            1.0,             0,           0.0d],
            [-100.0d,      10.0,           1.0,            1.0,             1,           0.0d],
            [-100.0d,      10.0,           1.0,            1.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      10.0,           1.0,            10.0,            0,           0.0d],
            [-100.0d,      10.0,           1.0,            10.0,            1,           0.0d],
            [-100.0d,      10.0,           1.0,            10.0,            10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      10.0,           10.0,           0.0,             0,           0.0d],
            [-100.0d,      10.0,           10.0,           0.0,             1,           0.0d],
            [-100.0d,      10.0,           10.0,           0.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      10.0,           10.0,           1.0,             0,           0.0d],
            [-100.0d,      10.0,           10.0,           1.0,             1,           0.0d],
            [-100.0d,      10.0,           10.0,           1.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      10.0,           10.0,           10.0,            0,           0.0d],
            [-100.0d,      10.0,           10.0,           10.0,            1,           0.0d],
            [-100.0d,      10.0,           10.0,           10.0,            10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,            1.0,           0.0,         0.0,             0,           0.0d],
            [-1.0d,            1.0,           0.0,         0.0,             1,           0.0d],
            [-1.0d,            1.0,           0.0,         0.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,            1.0,           0.0,         1.0,             0,           0.0d],
            [-1.0d,            1.0,           0.0,         1.0,             1,           0.0d],
            [-1.0d,            1.0,           0.0,         1.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,            1.0,           0.0,         10.0,            0,           0.0d],
            [-1.0d,            1.0,           0.0,         10.0,            1,           0.0d],
            [-1.0d,            1.0,           0.0,         10.0,            10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,            1.0,           1.0,         0.0,             0,           0.0d],
            [-1.0d,            1.0,           1.0,         0.0,             1,           0.0d],
            [-1.0d,            1.0,           1.0,         0.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,            1.0,           1.0,         1.0,             0,           0.0d],
            [-1.0d,            1.0,           1.0,         1.0,             1,           0.0d],
            [-1.0d,            1.0,           1.0,         1.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,            1.0,           1.0,         10.0,            0,           0.0d],
            [-1.0d,            1.0,           1.0,         10.0,            1,           0.0d],
            [-1.0d,            1.0,           1.0,         10.0,            10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,            1.0,           10.0,        0.0,             0,           0.0d],
            [-1.0d,            1.0,           10.0,        0.0,             1,           0.0d],
            [-1.0d,            1.0,           10.0,        0.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,          1.0,           10.0,          1.0,             0,           0.0d],
            [-1.0d,          1.0,           10.0,          1.0,             1,           0.0d],
            [-1.0d,          1.0,           10.0,          1.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,          1.0,           10.0,          10.0,            0,           0.0d],
            [-1.0d,          1.0,           10.0,          10.0,            1,           0.0d],
            [-1.0d,          1.0,           10.0,          10.0,            10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,          10.0,           0.0,          0.0,             0,           0.0d],
            [-1.0d,          10.0,           0.0,          0.0,             1,           0.0d],
            [-1.0d,          10.0,           0.0,          0.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,          10.0,           0.0,          1.0,             0,           0.0d],
            [-1.0d,          10.0,           0.0,          1.0,             1,           0.0d],
            [-1.0d,          10.0,           0.0,          1.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,          10.0,           0.0,          10.0,            0,           0.0d],
            [-1.0d,          10.0,           0.0,          10.0,            1,           0.0d],
            [-1.0d,          10.0,           0.0,          10.0,            10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,          10.0,           1.0,          0.0,             0,           0.0d],
            [-1.0d,          10.0,           1.0,          0.0,             1,           0.0d],
            [-1.0d,          10.0,           1.0,          0.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,          10.0,           1.0,          1.0,             0,           0.0d],
            [-1.0d,          10.0,           1.0,          1.0,             1,           0.0d],
            [-1.0d,          10.0,           1.0,          1.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,          10.0,           1.0,          10.0,            0,           0.0d],
            [-1.0d,          10.0,           1.0,          10.0,            1,           0.0d],
            [-1.0d,          10.0,           1.0,          10.0,            10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,          10.0,           10.0,         0.0,             0,           0.0d],
            [-1.0d,          10.0,           10.0,         0.0,             1,           0.0d],
            [-1.0d,          10.0,           10.0,         0.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,          10.0,           10.0,         1.0,             0,           0.0d],
            [-1.0d,          10.0,           10.0,         1.0,             1,           0.0d],
            [-1.0d,          10.0,           10.0,         1.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,          10.0,           10.0,         10.0,            0,           0.0d],
            [-1.0d,          10.0,           10.0,         10.0,            1,           0.0d],
            [-1.0d,          10.0,           10.0,         10.0,            10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,          1.0,           0.0,            0.0,             0,           0.0d],
            [0.0d,          1.0,           0.0,            0.0,             1,           0.0d],
            [0.0d,          1.0,           0.0,            0.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,          1.0,           0.0,            1.0,             0,           0.0d],
            [0.0d,          1.0,           0.0,            1.0,             1,           0.0d],
            [0.0d,          1.0,           0.0,            1.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,          1.0,           0.0,            10.0,            0,           0.0d],
            [0.0d,          1.0,           0.0,            10.0,            1,           0.0d],
            [0.0d,          1.0,           0.0,            10.0,            10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,          1.0,           1.0,            0.0,             0,           0.0d],
            [0.0d,          1.0,           1.0,            0.0,             1,           0.0d],
            [0.0d,          1.0,           1.0,            0.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,          1.0,           1.0,            1.0,             0,           0.0d],
            [0.0d,          1.0,           1.0,            1.0,             1,           0.0d],
            [0.0d,          1.0,           1.0,            1.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,          1.0,           1.0,            10.0,            0,           0.0d],
            [0.0d,          1.0,           1.0,            10.0,            1,           0.0d],
            [0.0d,          1.0,           1.0,            10.0,            10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,          1.0,           10.0,           0.0,             0,           0.0d],
            [0.0d,          1.0,           10.0,           0.0,             1,           0.0d],
            [0.0d,          1.0,           10.0,           0.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,          1.0,           10.0,           1.0,             0,           0.0d],
            [0.0d,          1.0,           10.0,           1.0,             1,           0.0d],
            [0.0d,          1.0,           10.0,           1.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,          1.0,           10.0,           10.0,            0,           0.0d],
            [0.0d,          1.0,           10.0,           10.0,            1,           0.0d],
            [0.0d,          1.0,           10.0,           10.0,            10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,          10.0,           0.0,           0.0,             0,           0.0d],
            [0.0d,          10.0,           0.0,           0.0,             1,           0.0d],
            [0.0d,          10.0,           0.0,           0.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,          10.0,           0.0,           1.0,             0,           0.0d],
            [0.0d,          10.0,           0.0,           1.0,             1,           0.0d],
            [0.0d,          10.0,           0.0,           1.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,          10.0,           0.0,           10.0,            0,           0.0d],
            [0.0d,          10.0,           0.0,           10.0,            1,           0.0d],
            [0.0d,          10.0,           0.0,           10.0,            10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,          10.0,           1.0,           0.0,             0,           0.0d],
            [0.0d,          10.0,           1.0,           0.0,             1,           0.0d],
            [0.0d,          10.0,           1.0,           0.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,          10.0,           1.0,           1.0,             0,           0.0d],
            [0.0d,          10.0,           1.0,           1.0,             1,           0.0d],
            [0.0d,          10.0,           1.0,           1.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,          10.0,           1.0,           10.0,            0,           0.0d],
            [0.0d,          10.0,           1.0,           10.0,            1,           0.0d],
            [0.0d,          10.0,           1.0,           10.0,            10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,          10.0,           10.0,          0.0,             0,           0.0d],
            [0.0d,          10.0,           10.0,          0.0,             1,           0.0d],
            [0.0d,          10.0,           10.0,          0.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,          10.0,           10.0,          1.0,             0,           0.0d],
            [0.0d,          10.0,           10.0,          1.0,             1,           0.0d],
            [0.0d,          10.0,           10.0,          1.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,          10.0,           10.0,          10.0,            0,           0.0d],
            [0.0d,          10.0,           10.0,          10.0,            1,           0.0d],
            [0.0d,          10.0,           10.0,          10.0,            10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,          1.0,           0.0,            0.0,             0,           1.0d],
            [1.0d,          1.0,           0.0,            0.0,             1,           1.0d],
            [1.0d,          1.0,           0.0,            0.0,             10,          1.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,          1.0,           0.0,            1.0,             0,           1.0d],
            [1.0d,          1.0,           0.0,            1.0,             1,           0.99d],
            [1.0d,          1.0,           0.0,            1.0,             10,          0.895d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,          1.0,           0.0,            10.0,            0,           1.0d],
            [1.0d,          1.0,           0.0,            10.0,            1,           0.9d],
            [1.0d,          1.0,           0.0,            10.0,            10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,          1.0,           1.0,            0.0,             0,           1.0d],
            [1.0d,          1.0,           1.0,            0.0,             1,           0.99d],
            [1.0d,          1.0,           1.0,            0.0,             10,          0.895d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,          1.0,           1.0,            1.0,             0,           1.0d],
            [1.0d,          1.0,           1.0,            1.0,             1,           0.98d],
            [1.0d,          1.0,           1.0,            1.0,             10,          0.79d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,          1.0,           1.0,            10.0,            0,           1.0d],
            [1.0d,          1.0,           1.0,            10.0,            1,           0.89d],
            [1.0d,          1.0,           1.0,            10.0,            10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,          1.0,           10.0,           0.0,             0,           1.0d],
            [1.0d,          1.0,           10.0,           0.0,             1,           0.9d],
            [1.0d,          1.0,           10.0,           0.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,          1.0,           10.0,           1.0,             0,           1.0d],
            [1.0d,          1.0,           10.0,           1.0,             1,           0.89d],
            [1.0d,          1.0,           10.0,           1.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,          1.0,           10.0,           10.0,            0,           1.0d],
            [1.0d,          1.0,           10.0,           10.0,            1,           0.8d],
            [1.0d,          1.0,           10.0,           10.0,            10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,          10.0,           0.0,           0.0,             0,           1.0d],
            [1.0d,          10.0,           0.0,           0.0,             1,           1.0d],
            [1.0d,          10.0,           0.0,           0.0,             10,          1.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,          10.0,           0.0,           1.0,             0,           1.0d],
            [1.0d,          10.0,           0.0,           1.0,             1,           0.99d],
            [1.0d,          10.0,           0.0,           1.0,             10,          0.84d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,          10.0,           0.0,           10.0,            0,           1.0d],
            [1.0d,          10.0,           0.0,           10.0,            1,           0.9d],
            [1.0d,          10.0,           0.0,           10.0,            10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,          10.0,           1.0,           0.0,             0,           1.0d],
            [1.0d,          10.0,           1.0,           0.0,             1,           0.99d],
            [1.0d,          10.0,           1.0,           0.0,             10,          0.84d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,          10.0,           1.0,           1.0,             0,           1.0d],
            [1.0d,          10.0,           1.0,           1.0,             1,           0.98d],
            [1.0d,          10.0,           1.0,           1.0,             10,          0.681d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,          10.0,           1.0,           10.0,            0,           1.0d],
            [1.0d,          10.0,           1.0,           10.0,            1,           0.89d],
            [1.0d,          10.0,           1.0,           10.0,            10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,          10.0,           10.0,          0.0,             0,           1.0d],
            [1.0d,          10.0,           10.0,          0.0,             1,           0.9d],
            [1.0d,          10.0,           10.0,          0.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,          10.0,           10.0,          1.0,             0,           1.0d],
            [1.0d,          10.0,           10.0,          1.0,             1,           0.89d],
            [1.0d,          10.0,           10.0,          1.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,          10.0,           10.0,          10.0,            0,           1.0d],
            [1.0d,          10.0,           10.0,          10.0,            1,           0.8d],
            [1.0d,          10.0,           10.0,          10.0,            10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,      1.0,           0.0,              0.0,             0,           100.0d],
            [100.0d,      1.0,           0.0,              0.0,             1,           100.0d],
            [100.0d,      1.0,           0.0,              0.0,             10,          100.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,      1.0,           0.0,              1.0,             0,           100.0d],
            [100.0d,      1.0,           0.0,              1.0,             1,           99.0d],
            [100.0d,      1.0,           0.0,              1.0,             10,          89.537d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,      1.0,           0.0,              10.0,            0,           100.0d],
            [100.0d,      1.0,           0.0,              10.0,            1,           90.0d],
            [100.0d,      1.0,           0.0,              10.0,            10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,      1.0,           1.0,              0.0,             0,           100.0d],
            [100.0d,      1.0,           1.0,              0.0,             1,           99.0d],
            [100.0d,      1.0,           1.0,              0.0,             10,          89.537d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,      1.0,           1.0,              1.0,             0,           100.0d],
            [100.0d,      1.0,           1.0,              1.0,             1,           98.0d],
            [100.0d,      1.0,           1.0,              1.0,             10,          79.075d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,      1.0,           1.0,              10.0,            0,           100.0d],
            [100.0d,      1.0,           1.0,              10.0,            1,           89.0d],
            [100.0d,      1.0,           1.0,              10.0,            10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,      1.0,           10.0,             0.0,             0,           100.0d],
            [100.0d,      1.0,           10.0,             0.0,             1,           90.0d],
            [100.0d,      1.0,           10.0,             0.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,      1.0,           10.0,             1.0,             0,           100.0d],
            [100.0d,      1.0,           10.0,             1.0,             1,           89.0d],
            [100.0d,      1.0,           10.0,             1.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,      1.0,           10.0,             10.0,            0,           100.0d],
            [100.0d,      1.0,           10.0,             10.0,            1,           80.0d],
            [100.0d,      1.0,           10.0,             10.0,            10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,      10.0,           0.0,             0.0,             0,           100.0d],
            [100.0d,      10.0,           0.0,             0.0,             1,           100.0d],
            [100.0d,      10.0,           0.0,             0.0,             10,          100.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,      10.0,           0.0,             1.0,             0,           100.0d],
            [100.0d,      10.0,           0.0,             1.0,             1,           99.0d],
            [100.0d,      10.0,           0.0,             1.0,             10,          84.062d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,      10.0,           0.0,             10.0,            0,           100.0d],
            [100.0d,      10.0,           0.0,             10.0,            1,           90.0d],
            [100.0d,      10.0,           0.0,             10.0,            10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,      10.0,           1.0,             0.0,             0,           100.0d],
            [100.0d,      10.0,           1.0,             0.0,             1,           99.0d],
            [100.0d,      10.0,           1.0,             0.0,             10,          84.062d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,      10.0,           1.0,             1.0,             0,           100.0d],
            [100.0d,      10.0,           1.0,             1.0,             1,           98.0d],
            [100.0d,      10.0,           1.0,             1.0,             10,          68.125d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,      10.0,           1.0,             10.0,            0,           100.0d],
            [100.0d,      10.0,           1.0,             10.0,            1,           89.0d],
            [100.0d,      10.0,           1.0,             10.0,            10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,      10.0,           10.0,            0.0,             0,           100.0d],
            [100.0d,      10.0,           10.0,            0.0,             1,           90.0d],
            [100.0d,      10.0,           10.0,            0.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,      10.0,           10.0,            1.0,             0,           100.0d],
            [100.0d,      10.0,           10.0,            1.0,             1,           89.0d],
            [100.0d,      10.0,           10.0,            1.0,             10,          0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,      10.0,           10.0,            10.0,            0,           100.0d],
            [100.0d,      10.0,           10.0,            10.0,            1,           80.0d],
            [100.0d,      10.0,           10.0,            10.0,            10,          0.0d],

            

        ]*.toArray()
    }

    
    @Test
    public void testAccumulationFactorByYearsAndInterest() {
        assertThat(AnnuityCalculator.calculateRestLoanInYear(capital, interest, redemption, specialRedemption, endOfYear)).isCloseTo(expected, offset(0.001d))
    }

}
