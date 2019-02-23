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
class AnnuityCalculatorCalculateRedemptionAfterYearTest {
    def capital, interest, redemption, specialRedemption, endOfYear, expected
    
    
    public AnnuityCalculatorCalculateRedemptionAfterYearTest(capital, interest, redemption, specialRedemption, endOfYear, expected) {
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
            [-100.0d,      1.0,           0.0,         0.0,                  0,            -1.0d],
            [-100.0d,      1.0,           0.0,         0.0,                  1,            -1.0d], 
            [-100.0d,      1.0,           0.0,         0.0,                  10,           -1.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      1.0,           0.0,         1.0,                  0,            -2.0d],
            [-100.0d,      1.0,           0.0,         1.0,                  1,            -2.0d],
            [-100.0d,      1.0,           0.0,         1.0,                  10,           -2.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      1.0,           0.0,         10.0,                 0,            -11.0d],
            [-100.0d,      1.0,           0.0,         10.0,                 1,            -11.0d],
            [-100.0d,      1.0,           0.0,         10.0,                 10,           -11.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      1.0,           1.0,         0.0,                  0,            -2.0d],
            [-100.0d,      1.0,           1.0,         0.0,                  1,            -2.0d],
            [-100.0d,      1.0,           1.0,         0.0,                  10,           -2.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      1.0,           1.0,         1.0,                  0,            -3.0d],
            [-100.0d,      1.0,           1.0,         1.0,                  1,            -3.0d],
            [-100.0d,      1.0,           1.0,         1.0,                  10,           -3.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      1.0,           1.0,         10.0,                 0,            -12.0d],
            [-100.0d,      1.0,           1.0,         10.0,                 1,            -12.0d],
            [-100.0d,      1.0,           1.0,         10.0,                 10,           -12.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      1.0,           10.0,        0.0,                  0,            -11.0d],
            [-100.0d,      1.0,           10.0,        0.0,                  1,            -11.0d],
            [-100.0d,      1.0,           10.0,        0.0,                  10,           -11.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      1.0,           10.0,        1.0,                  0,            -12.0d],
            [-100.0d,      1.0,           10.0,        1.0,                  1,            -12.0d],
            [-100.0d,      1.0,           10.0,        1.0,                  10,           -12.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      1.0,           10.0,        10.0,                 0,            -21.0d],
            [-100.0d,      1.0,           10.0,        10.0,                 1,            -21.0d],
            [-100.0d,      1.0,           10.0,        10.0,                 10,           -21.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      10.0,          0.0,         0.0,                  0,            -10.0d],
            [-100.0d,      10.0,          0.0,         0.0,                  1,            -10.0d],
            [-100.0d,      10.0,          0.0,         0.0,                  10,           -10.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      10.0,          0.0,         1.0,                  0,            -11.0d],
            [-100.0d,      10.0,          0.0,         1.0,                  1,            -11.0d],
            [-100.0d,      10.0,          0.0,         1.0,                  10,           -11.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      10.0,          0.0,         10.0,                 0,            -20.0d],
            [-100.0d,      10.0,          0.0,         10.0,                 1,            -20.0d],
            [-100.0d,      10.0,          0.0,         10.0,                 10,           -20.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      10.0,          1.0,         0.0,                  0,            -11.0d],
            [-100.0d,      10.0,          1.0,         0.0,                  1,            -11.0d],
            [-100.0d,      10.0,          1.0,         0.0,                  10,           -11.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      10.0,          1.0,         1.0,                  0,            -12.0d],
            [-100.0d,      10.0,          1.0,         1.0,                  1,            -12.0d],
            [-100.0d,      10.0,          1.0,         1.0,                  10,           -12.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      10.0,          1.0,         10.0,                 0,            -21.0d],
            [-100.0d,      10.0,          1.0,         10.0,                 1,            -21.0d],
            [-100.0d,      10.0,          1.0,         10.0,                 10,           -21.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      10.0,          10.0,        0.0,                  0,            -20.0d],
            [-100.0d,      10.0,          10.0,        0.0,                  1,            -20.0d],
            [-100.0d,      10.0,          10.0,        0.0,                  10,           -20.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      10.0,          10.0,        1.0,                  0,            -21.0d],
            [-100.0d,      10.0,          10.0,        1.0,                  1,            -21.0d],
            [-100.0d,      10.0,          10.0,        1.0,                  10,           -21.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      10.0,          10.0,        10.0,                 0,            -30.0d],
            [-100.0d,      10.0,          10.0,        10.0,                 1,            -30.0d],
            [-100.0d,      10.0,          10.0,        10.0,                 10,           -30.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        1.0,           0.0,         0.0,                  0,            -0.01d],
            [-1.0d,        1.0,           0.0,         0.0,                  1,            -0.01d],
            [-1.0d,        1.0,           0.0,         0.0,                  10,           -0.01d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        1.0,           0.0,         1.0,                  0,            -0.02d],
            [-1.0d,        1.0,           0.0,         1.0,                  1,            -0.02d],
            [-1.0d,        1.0,           0.0,         1.0,                  10,           -0.02d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        1.0,           0.0,         10.0,                 0,            -0.11d],
            [-1.0d,        1.0,           0.0,         10.0,                 1,            -0.11d],
            [-1.0d,        1.0,           0.0,         10.0,                 10,           -0.11d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        1.0,           1.0,         0.0,                  0,            -0.02d],
            [-1.0d,        1.0,           1.0,         0.0,                  1,            -0.02d],
            [-1.0d,        1.0,           1.0,         0.0,                  10,           -0.02d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        1.0,           1.0,         1.0,                  0,            -0.03d],
            [-1.0d,        1.0,           1.0,         1.0,                  1,            -0.03d],
            [-1.0d,        1.0,           1.0,         1.0,                  10,           -0.03d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        1.0,           1.0,         10.0,                 0,            -0.12d],
            [-1.0d,        1.0,           1.0,         10.0,                 1,            -0.12d],
            [-1.0d,        1.0,           1.0,         10.0,                 10,           -0.12d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        1.0,           10.0,        0.0,                  0,            -0.11d],
            [-1.0d,        1.0,           10.0,        0.0,                  1,            -0.11d],
            [-1.0d,        1.0,           10.0,        0.0,                  10,           -0.11d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        1.0,           10.0,        1.0,                  0,            -0.12d],
            [-1.0d,        1.0,           10.0,        1.0,                  1,            -0.12d],
            [-1.0d,        1.0,           10.0,        1.0,                  10,           -0.12d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        1.0,           10.0,        10.0,                 0,            -0.21d],
            [-1.0d,        1.0,           10.0,        10.0,                 1,            -0.21d],
            [-1.0d,        1.0,           10.0,        10.0,                 10,           -0.21d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        10.0,          0.0,         0.0,                  0,            -0.1d],
            [-1.0d,        10.0,          0.0,         0.0,                  1,            -0.1d],
            [-1.0d,        10.0,          0.0,         0.0,                  10,           -0.1d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        10.0,          0.0,         1.0,                  0,            -0.11d],
            [-1.0d,        10.0,          0.0,         1.0,                  1,            -0.11d],
            [-1.0d,        10.0,          0.0,         1.0,                  10,           -0.11d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        10.0,          0.0,         10.0,                 0,            -0.2d],
            [-1.0d,        10.0,          0.0,         10.0,                 1,            -0.2d],
            [-1.0d,        10.0,          0.0,         10.0,                 10,           -0.2d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        10.0,          1.0,         0.0,                  0,            -0.11d],
            [-1.0d,        10.0,          1.0,         0.0,                  1,            -0.11d],
            [-1.0d,        10.0,          1.0,         0.0,                  10,           -0.11d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        10.0,          1.0,         1.0,                  0,            -0.12d],
            [-1.0d,        10.0,          1.0,         1.0,                  1,            -0.12d],
            [-1.0d,        10.0,          1.0,         1.0,                  10,           -0.12d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        10.0,          1.0,         10.0,                 0,            -0.21d],
            [-1.0d,        10.0,          1.0,         10.0,                 1,            -0.21d],
            [-1.0d,        10.0,          1.0,         10.0,                 10,           -0.21d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        10.0,          10.0,        0.0,                  0,            -0.2d],
            [-1.0d,        10.0,          10.0,        0.0,                  1,            -0.2d],
            [-1.0d,        10.0,          10.0,        0.0,                  10,           -0.2d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        10.0,          10.0,        1.0,                  0,            -0.21d],
            [-1.0d,        10.0,          10.0,        1.0,                  1,            -0.21d],
            [-1.0d,        10.0,          10.0,        1.0,                  10,           -0.21d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        10.0,          10.0,        10.0,                 0,            -0.3d],
            [-1.0d,        10.0,          10.0,        10.0,                 1,            -0.3d],
            [-1.0d,        10.0,          10.0,        10.0,                 10,           -0.3d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         1.0,           0.0,         0.0,                  0,            0.0d],
            [0.0d,         1.0,           0.0,         0.0,                  1,            0.0d],
            [0.0d,         1.0,           0.0,         0.0,                  10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         1.0,           0.0,         1.0,                  0,            0.0d],
            [0.0d,         1.0,           0.0,         1.0,                  1,            0.0d],
            [0.0d,         1.0,           0.0,         1.0,                  10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         1.0,           0.0,         10.0,                 0,            0.0d],
            [0.0d,         1.0,           0.0,         10.0,                 1,            0.0d],
            [0.0d,         1.0,           0.0,         10.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         1.0,           1.0,         0.0,                  0,            0.0d],
            [0.0d,         1.0,           1.0,         0.0,                  1,            0.0d],
            [0.0d,         1.0,           1.0,         0.0,                  10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         1.0,           1.0,         1.0,                  0,            0.0d],
            [0.0d,         1.0,           1.0,         1.0,                  1,            0.0d],
            [0.0d,         1.0,           1.0,         1.0,                  10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         1.0,           1.0,         10.0,                 0,            0.0d],
            [0.0d,         1.0,           1.0,         10.0,                 1,            0.0d],
            [0.0d,         1.0,           1.0,         10.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         1.0,           10.0,        0.0,                  0,            0.0d],
            [0.0d,         1.0,           10.0,        0.0,                  1,            0.0d],
            [0.0d,         1.0,           10.0,        0.0,                  10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         1.0,           10.0,        1.0,                  0,            0.0d],
            [0.0d,         1.0,           10.0,        1.0,                  1,            0.0d],
            [0.0d,         1.0,           10.0,        1.0,                  10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         1.0,           10.0,        10.0,                 0,            0.0d],
            [0.0d,         1.0,           10.0,        10.0,                 1,            0.0d],
            [0.0d,         1.0,           10.0,        10.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         10.0,          0.0,         0.0,                  0,            0.0d],
            [0.0d,         10.0,          0.0,         0.0,                  1,            0.0d],
            [0.0d,         10.0,          0.0,         0.0,                  10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         10.0,          0.0,         1.0,                  0,            0.0d],
            [0.0d,         10.0,          0.0,         1.0,                  1,            0.0d],
            [0.0d,         10.0,          0.0,         1.0,                  10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         10.0,          0.0,         10.0,                 0,            0.0d],
            [0.0d,         10.0,          0.0,         10.0,                 1,            0.0d],
            [0.0d,         10.0,          0.0,         10.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         10.0,          1.0,         0.0,                  0,            0.0d],
            [0.0d,         10.0,          1.0,         0.0,                  1,            0.0d],
            [0.0d,         10.0,          1.0,         0.0,                  10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         10.0,          1.0,         1.0,                  0,            0.0d],
            [0.0d,         10.0,          1.0,         1.0,                  1,            0.0d],
            [0.0d,         10.0,          1.0,         1.0,                  10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         10.0,          1.0,         10.0,                 0,            0.0d],
            [0.0d,         10.0,          1.0,         10.0,                 1,            0.0d],
            [0.0d,         10.0,          1.0,         10.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         10.0,          10.0,        0.0,                  0,            0.0d],
            [0.0d,         10.0,          10.0,        0.0,                  1,            0.0d],
            [0.0d,         10.0,          10.0,        0.0,                  10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         10.0,          10.0,        1.0,                  0,            0.0d],
            [0.0d,         10.0,          10.0,        1.0,                  1,            0.0d],
            [0.0d,         10.0,          10.0,        1.0,                  10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         10.0,          10.0,        10.0,                 0,            0.0d],
            [0.0d,         10.0,          10.0,        10.0,                 1,            0.0d],
            [0.0d,         10.0,          10.0,        10.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         1.0,           0.0,         0.0,                  0,            0.0d],
            [1.0d,         1.0,           0.0,         0.0,                  1,            0.0d],
            [1.0d,         1.0,           0.0,         0.0,                  10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         1.0,           0.0,         1.0,                  0,            0.011d],
            [1.0d,         1.0,           0.0,         1.0,                  1,            0.011d],
            [1.0d,         1.0,           0.0,         1.0,                  10,           0.011d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         1.0,           0.0,         10.0,                 0,            0.1d],
            [1.0d,         1.0,           0.0,         10.0,                 1,            0.101d],
            [1.0d,         1.0,           0.0,         10.0,                 10,           0.11d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         1.0,           1.0,         0.0,                  0,            0.01d],
            [1.0d,         1.0,           1.0,         0.0,                  1,            0.01d],
            [1.0d,         1.0,           1.0,         0.0,                  10,           0.011d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         1.0,           1.0,         1.0,                  0,            0.019d],
            [1.0d,         1.0,           1.0,         1.0,                  1,            0.02d],
            [1.0d,         1.0,           1.0,         1.0,                  10,           0.022d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         1.0,           1.0,         10.0,                 0,            0.11d],
            [1.0d,         1.0,           1.0,         10.0,                 1,            0.111d],
            [1.0d,         1.0,           1.0,         10.0,                 10,           0.12d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         1.0,           10.0,        0.0,                  0,            0.1d],
            [1.0d,         1.0,           10.0,        0.0,                  1,            0.101d],
            [1.0d,         1.0,           10.0,        0.0,                  10,           0.11d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         1.0,           10.0,        1.0,                  0,            0.11d],
            [1.0d,         1.0,           10.0,        1.0,                  1,            0.111d],
            [1.0d,         1.0,           10.0,        1.0,                  10,           0.12d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         1.0,           10.0,        10.0,                 0,            0.199d],
            [1.0d,         1.0,           10.0,        10.0,                 1,            0.201d],
            [1.0d,         1.0,           10.0,        10.0,                 10,           0.21d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         10.0,          0.0,         0.0,                  0,            0.0d],
            [1.0d,         10.0,          0.0,         0.0,                  1,            0.0d],
            [1.0d,         10.0,          0.0,         0.0,                  10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         10.0,          0.0,         1.0,                  0,            0.009d],
            [1.0d,         10.0,          0.0,         1.0,                  1,            0.01d],
            [1.0d,         10.0,          0.0,         1.0,                  10,           0.025d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         10.0,          0.0,         10.0,                 0,            0.1d],
            [1.0d,         10.0,          0.0,         10.0,                 1,            0.11d],
            [1.0d,         10.0,          0.0,         10.0,                 10,           0.2d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         10.0,          1.0,         0.0,                  0,            0.009d],
            [1.0d,         10.0,          1.0,         0.0,                  1,            0.01d],
            [1.0d,         10.0,          1.0,         0.0,                  10,           0.025d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         10.0,          1.0,         1.0,                  0,            0.019d],
            [1.0d,         10.0,          1.0,         1.0,                  1,            0.021d],
            [1.0d,         10.0,          1.0,         1.0,                  10,           0.051d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         10.0,          1.0,         10.0,                 0,            0.109d],
            [1.0d,         10.0,          1.0,         10.0,                 1,            0.12d],
            [1.0d,         10.0,          1.0,         10.0,                 10,           0.21d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         10.0,          10.0,        0.0,                  0,            0.1d],
            [1.0d,         10.0,          10.0,        0.0,                  1,            0.11d],
            [1.0d,         10.0,          10.0,        0.0,                  10,           0.2d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         10.0,          10.0,        1.0,                  0,            0.109d],
            [1.0d,         10.0,          10.0,        1.0,                  1,            0.12d],
            [1.0d,         10.0,          10.0,        1.0,                  10,           0.21d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         10.0,          10.0,        10.0,                 0,            0.199d],
            [1.0d,         10.0,          10.0,        10.0,                 1,            0.219d],
            [1.0d,         10.0,          10.0,        10.0,                 10,           0.3d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       1.0,           0.0,         0.0,                  0,            0.0d],
            [100.0d,       1.0,           0.0,         0.0,                  1,            0.0d],
            [100.0d,       1.0,           0.0,         0.0,                  10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       1.0,           0.0,         1.0,                  0,            1.0d],
            [100.0d,       1.0,           0.0,         1.0,                  1,            1.01d],
            [100.0d,       1.0,           0.0,         1.0,                  10,           1.1042d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       1.0,           0.0,         10.0,                 0,            10.0d],
            [100.0d,       1.0,           0.0,         10.0,                 1,            10.1d],
            [100.0d,       1.0,           0.0,         10.0,                 10,           11.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       1.0,           1.0,         0.0,                  0,            1.0d],
            [100.0d,       1.0,           1.0,         0.0,                  1,            1.01d],
            [100.0d,       1.0,           1.0,         0.0,                  10,           1.104d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       1.0,           1.0,         1.0,                  0,            2.0d],
            [100.0d,       1.0,           1.0,         1.0,                  1,            2.02d],
            [100.0d,       1.0,           1.0,         1.0,                  10,           2.209d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       1.0,           1.0,         10.0,                 0,            11.0d],
            [100.0d,       1.0,           1.0,         10.0,                 1,            11.11d],
            [100.0d,       1.0,           1.0,         10.0,                 10,           12.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       1.0,           10.0,        0.0,                  0,            10.0d],
            [100.0d,       1.0,           10.0,        0.0,                  1,            10.1d],
            [100.0d,       1.0,           10.0,        0.0,                  10,           11.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       1.0,           10.0,        1.0,                  0,            11.0d],
            [100.0d,       1.0,           10.0,        1.0,                  1,            11.11d],
            [100.0d,       1.0,           10.0,        1.0,                  10,           12.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       1.0,           10.0,        10.0,                 0,            20.0d],
            [100.0d,       1.0,           10.0,        10.0,                 1,            20.2d],
            [100.0d,       1.0,           10.0,        10.0,                 10,           21.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       10.0,          0.0,         0.0,                  0,            0.0d],
            [100.0d,       10.0,          0.0,         0.0,                  1,            0.0d],
            [100.0d,       10.0,          0.0,         0.0,                  10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       10.0,          0.0,         1.0,                  0,            1.0d],
            [100.0d,       10.0,          0.0,         1.0,                  1,            1.099d],
            [100.0d,       10.0,          0.0,         1.0,                  10,           2.593d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       10.0,          0.0,         10.0,                 0,            10.0d],
            [100.0d,       10.0,          0.0,         10.0,                 1,            11.0d],
            [100.0d,       10.0,          0.0,         10.0,                 10,           20.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       10.0,          1.0,         0.0,                  0,            1.0d],
            [100.0d,       10.0,          1.0,         0.0,                  1,            1.099d],
            [100.0d,       10.0,          1.0,         0.0,                  10,           2.593d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       10.0,          1.0,         1.0,                  0,            2.0d],
            [100.0d,       10.0,          1.0,         1.0,                  1,            2.199d],
            [100.0d,       10.0,          1.0,         1.0,                  10,           5.187d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       10.0,          1.0,         10.0,                 0,            11.0d],
            [100.0d,       10.0,          1.0,         10.0,                 1,            12.1d],
            [100.0d,       10.0,          1.0,         10.0,                 10,           21.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       10.0,          10.0,        0.0,                  0,            10.0d],
            [100.0d,       10.0,          10.0,        0.0,                  1,            11.0d],
            [100.0d,       10.0,          10.0,        0.0,                  10,           20.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       10.0,          10.0,        1.0,                  0,            11.0d],
            [100.0d,       10.0,          10.0,        1.0,                  1,            12.1d],
            [100.0d,       10.0,          10.0,        1.0,                  10,           21.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       10.0,          10.0,        10.0,                 0,            20.0d],
            [100.0d,       10.0,          10.0,        10.0,                 1,            22.0d],
            [100.0d,       10.0,          10.0,        10.0,                 10,           30.0d],

        ]*.toArray()
    }

    
    @Test
    public void testAccumulationFactorByYearsAndInterest() {
        assertThat(AnnuityCalculator.calculateRedemptionAfterYear(capital, interest, redemption, specialRedemption, endOfYear)).isCloseTo(expected, offset(0.001d))
    }

}
