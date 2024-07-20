package com.epam.rd.qa.basicio;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MatrixOperationsTest {
    static final Matrix EXPECTED1 = new Matrix(new double[][] {
            {19.405739780310746, -24.266224178399767, -8.507210454092927, 1.8509800487144847, 31.64891754927551},
            {10.89611668839592, 17.636997658535698, 10.196804396902994, -23.129256463032625, 33.48934471346062},
            {-38.588471454158004, -3.693250976584295, -11.910390223481485, 29.799410865819866, -1.4533117660594996},
            {26.754365609674338, -24.644591327884523, 4.564819663245668, -22.487369373335014, 21.1719066292007},
            {-6.266009644405628, 3.293461030823959, -12.383038947352304, -23.878867683781632, 2.720470210361526}
    });
    static final Matrix EXPECTED2 = new Matrix(new double[][] {
            {23.04302967434272, -24.21972094042196, -44.07980341887554, -25.588274943574685, 31.880902285523163},
            {-12.938887398635856, 35.628293294145976, 21.498467639589748, -21.27431131855595, 41.62469512617625},
            {-49.17238515749963, -5.937751954557733, -46.86660515048868, 42.27110770321573, 46.21037571047796},
            {30.078102179429933, -6.309716419317688, 31.47494366843138, -28.4768780034783, 45.701467085016645},
            {-28.392602115664147, -10.479754670378703, -20.105595575577652, -2.694932683800424, -12.25785290296895}
    });
    static final Matrix EXPECTED3 = new Matrix(new double[][] {
            {15.768449886278773, -24.312727416377577, 27.065382510689687, 29.290235041003655, 31.416932813027856},
            {34.7311207754277, -0.3542979770745802, -1.1048588457837596, -24.984201607509306, 25.353994300744986},
            {-28.00455775081637, -1.4487499986108574, 23.04582470352571, 17.327714028423998, -49.11699924259696},
            {23.430629039918742, -42.97946623645136, -22.345304341940043, -16.49786074319173, -3.3576538266152482},
            {15.860582826852891, 17.06667673202662, -4.660482319126956, -45.06280268376284, 17.698793323692}
    });
    static final Matrix EXPECTED4 = new Matrix(new double[][] {{-5.725009092488193, -11.230653955656862, 32.28970502348244}});
    static final Matrix EXPECTED5 = new Matrix(new double[][] {{22.99823878824023, -39.44752153994797, 41.06890605104496}});
    static final Matrix EXPECTED6 = new Matrix(new double[][] {{-34.448256973216616, 16.986213628634246, 23.51050399591992}});
    static final Matrix EXPECTED7 = new Matrix(new double[][] {{35.85119346280537}, {37.92858341878704}, {24.212171366465867}});
    static final Matrix EXPECTED8 = new Matrix(new double[][] {{23.11469360199058}, {40.144762403005444}, {-0.317740656910928}});
    static final Matrix EXPECTED9 = new Matrix(new double[][] {{48.58769332362016}, {35.71240443456864}, {48.74208338984266}});
    static final Matrix EXPECTED_ZEROS_22 = new Matrix(new double[][] {{0., 0.}, {0., 0.}});
    static final Matrix EXPECTED11 = new Matrix(new double[][] {
            {3.637289894031973, 0.04650323797780764, -35.572592964782615, -27.43925499228917, 0.2319847362476537},
            {-23.835004087031777, 17.99129563561028, 11.301663242686754, 1.8549451444766785, 8.135350412715631},
            {-10.583913703341631, -2.2445009779734377, -34.956214927007196, 12.471696837395868, 47.66368747653746},
            {3.323736569755596, 18.334874908566835, 26.91012400518571, -5.989508630143286, 24.529560455815947},
            {-22.12659247125852, -13.773215701202663, -7.722556628225348, 21.183934999981208, -14.978323113330475}
    });
    static final Matrix EXPECTED12 = new Matrix(new double[][] {
            {-3.637289894031973, -0.04650323797780764, 35.572592964782615, 27.43925499228917, -0.2319847362476537},
            {23.835004087031777, -17.99129563561028, -11.301663242686754, -1.8549451444766785, -8.135350412715631},
            {10.583913703341631, 2.2445009779734377, 34.956214927007196, -12.471696837395868, -47.66368747653746},
            {-3.323736569755596, -18.334874908566835, -26.91012400518571, 5.989508630143286, -24.529560455815947},
            {22.12659247125852, 13.773215701202663, 7.722556628225348, -21.183934999981208, 14.978323113330475}
    });
    static final Matrix EXPECTED_ZEROS_55 = new Matrix(new double[][] {
            {0.0, 0.0, 0.0, 0.0, 0.0},
            {0.0, 0.0, 0.0, 0.0, 0.0},
            {0.0, 0.0, 0.0, 0.0, 0.0},
            {0.0, 0.0, 0.0, 0.0, 0.0},
            {0.0, 0.0, 0.0, 0.0, 0.0}});
    static final Matrix EXPECTED14 = new Matrix(new double[][] {{28.723247880728422, -28.21686758429111, 8.779201027562522}});
    static final Matrix EXPECTED15 = new Matrix(new double[][] {{-28.723247880728422, 28.21686758429111, -8.779201027562522}});
    static final Matrix EXPECTED_ZEROS_13 = new Matrix(new double[][] {{0.0, 0.0, 0.0}});
    static final Matrix EXPECTED17 = new Matrix(new double[][] {
            {-12.736499860814789},
            {2.216178984218402},
            {-24.529912023376795}
    });
    static final Matrix EXPECTED18 = new Matrix(new double[][] {
            {12.736499860814789},
            {-2.216178984218402},
            {24.529912023376795}
    });
    static final Matrix EXPECTED_ZEROS_31 = new Matrix(new double[][] {
            {0.0},
            {0.0},
            {0.0}
    });
    static final Matrix EXPECTED20 = new Matrix(new double[][] {
            {165.67762983187203, 289.0185415438315, 14.442443121834856, -124.5617735988103, 731.2780973355359},
            {148.2626773577981, 473.89111649943845, 96.81988757677154, -605.3382535153055, 62.254454820821024},
            {513.5609035562467, 59.34610550210462, -891.0780019213299, -1220.9409373311325, 320.6229755724985},
            {-142.16990362437784, 307.3121693165759, 492.43658685157607, -1.4004733579342883, 35.87668394559253},
            {-126.54832389836349, 157.44212217278843, -275.7203551386232, -80.33696639839587, -94.52153616671612}
    });
    static final Matrix EXPECTED21 = new Matrix(new double[][] {
            {-165.9876757101424, -480.7226980809807, -548.9916993968206, 84.76795776369121, 423.7266524367812},
            {-153.03005701354198, -238.82528016954143, -695.7275876134956, -71.18271900447945, -102.78605499860012},
            {38.99033973280467, 223.80170843493798, 414.0313185957416, 340.12745704224005, 376.4531939945091},
            {448.47481346780035, -456.70080994651266, -340.3308095427671, -37.723845178379946, -696.8553264741328},
            {-371.0248191344774, 87.61123903648901, -471.9992369428143, 67.40509493964858, -318.92578265234766}
    });
    static final Matrix EXPECTED22 = new Matrix(new double[][] {
            {140.0918517986432, -361.01195989611614},
            {-90.08818785643649, 196.2596972844919}
    });
    static final Matrix EXPECTED23 = new Matrix(new double[][] {
            {151.60669120386495, -249.62620552507843, 249.69475251911433},
            {-267.3284147171235, 42.35336339608587, 363.1294418123016},
            {39.59122599568751, -103.40680397190812, 142.3914944831843}
    });
    static final Matrix EXPECTED24 = new Matrix(new double[][] {
            {280.7724110007408, 206.37032157385596, 281.6645807697219},
            {487.63535104670626, 358.416497716449, 489.184839178178},
            {-3.8595713986084452, -2.8368207112271446, -3.87183539887396}
    });
    static final Matrix EXPECTED25 = new Matrix(new double[][] {
            {635.3170733183159}
    });

    @ParameterizedTest
    @MethodSource("casesAddMatrixShouldReturn")
    void testAddMatrixShouldReturn(Matrix m1, Matrix m2, Matrix expected) {
        assertArrayEquals(expected.toArray(), m1.add(m2).toArray());
    }

    static Stream<Arguments> casesAddMatrixShouldReturn() {
        Random r = new Random(10);
        Matrix m1 = randomInit(r, 5, 5);
        Matrix m2 = randomInit(r, 5, 5);
        r = new Random(15);
        Matrix m3 = randomInit(r, 1, 3);
        Matrix m4 = randomInit(r, 1, 3);
        r = new Random(2);
        Matrix m5 = randomInit(r, 3, 1);
        Matrix m6 = randomInit(r, 3, 1);
        return Stream.of(
                Arguments.of(m1, m2, EXPECTED1),
                Arguments.of(m1, m1, EXPECTED2),
                Arguments.of(m2, m2, EXPECTED3),
                Arguments.of(m3, m4, EXPECTED4),
                Arguments.of(m3, m3, EXPECTED5),
                Arguments.of(m4, m4, EXPECTED6),
                Arguments.of(m5, m6, EXPECTED7),
                Arguments.of(m5, m5, EXPECTED8),
                Arguments.of(m6, m6, EXPECTED9),
                Arguments.of(new Matrix(2,2), new Matrix(2, 2), EXPECTED_ZEROS_22)
        );
    }

    @ParameterizedTest
    @MethodSource("casesAddMatrixShouldThrow")
    void testAddMatrixShouldThrow(Matrix m1, Matrix m2) {
        assertThrows(MatrixException.class, () -> m1.add(m2));
    }

    static Stream<Arguments> casesAddMatrixShouldThrow() {
        return Stream.of(
                Arguments.of(new Matrix(1,1), new Matrix(2,2)),
                Arguments.of(new Matrix(2,1), new Matrix(1,2)),
                Arguments.of(new Matrix(1,2), new Matrix(2,1))
        );
    }

    @ParameterizedTest
    @MethodSource("casesSubMatrixShouldReturn")
    void testSubMatrixShouldReturn(Matrix m1, Matrix m2, Matrix expected) {
        assertArrayEquals(expected.toArray(), m1.subtract(m2).toArray());
    }

    static Stream<Arguments> casesSubMatrixShouldReturn() {
        Random r = new Random(10);
        Matrix m1 = randomInit(r, 5, 5);
        Matrix m2 = randomInit(r, 5, 5);
        r = new Random(15);
        Matrix m3 = randomInit(r, 1, 3);
        Matrix m4 = randomInit(r, 1, 3);
        r = new Random(2);
        Matrix m5 = randomInit(r, 3, 1);
        Matrix m6 = randomInit(r, 3, 1);
        return Stream.of(
                Arguments.of(m1, m2, EXPECTED11),
                Arguments.of(m2, m1, EXPECTED12),
                Arguments.of(m1, m1, EXPECTED_ZEROS_55),
                Arguments.of(m3, m4, EXPECTED14),
                Arguments.of(m4, m3, EXPECTED15),
                Arguments.of(m4, m4, EXPECTED_ZEROS_13),
                Arguments.of(m5, m6, EXPECTED17),
                Arguments.of(m6, m5, EXPECTED18),
                Arguments.of(m6, m6, EXPECTED_ZEROS_31),
                Arguments.of(new Matrix(2,2), new Matrix(2, 2), EXPECTED_ZEROS_22)
        );
    }

    @ParameterizedTest
    @MethodSource("casesSubMatrixShouldThrow")
    void testSubMatrixShouldThrow(Matrix m1, Matrix m2) {
        assertThrows(MatrixException.class, () -> m1.subtract(m2));
    }

    static Stream<Arguments> casesSubMatrixShouldThrow() {
        return Stream.of(
                Arguments.of(new Matrix(1,1), new Matrix(2,2)),
                Arguments.of(new Matrix(2,1), new Matrix(1,2)),
                Arguments.of(new Matrix(1,2), new Matrix(2,1))
        );
    }

    @ParameterizedTest
    @MethodSource("casesMultipleMatrixShouldReturn")
    void testMultipleMatrixShouldReturn(Matrix m1, Matrix m2, Matrix expected) {
        assertArrayEquals(expected.toArray(), m1.multiply(m2).toArray());
    }

    static Stream<Arguments> casesMultipleMatrixShouldReturn() {
        Random r = new Random(10);
        Matrix m1 = randomInit(r, 5, 5);
        Matrix m2 = randomInit(r, 5, 5);
        r = new Random(15);
        Matrix m3 = randomInit(r, 2, 3);
        Matrix m4 = randomInit(r, 3, 2);
        r = new Random(2);
        Matrix m5 = randomInit(r, 3, 1);
        Matrix m6 = randomInit(r, 1, 3);
        return Stream.of(
                Arguments.of(m1, m2, EXPECTED20),
                Arguments.of(m2, m1, EXPECTED21),
                Arguments.of(m3, m4, EXPECTED22),
                Arguments.of(m4, m3, EXPECTED23),
                Arguments.of(m5, m6, EXPECTED24),
                Arguments.of(m6, m5, EXPECTED25),
                Arguments.of(new Matrix(2,2), new Matrix(2, 2), EXPECTED_ZEROS_22)
        );
    }

    @ParameterizedTest
    @MethodSource("casesMultipleMatrixShouldThrow")
    void testMultipleMatrixShouldThrow(Matrix m1, Matrix m2) {
        assertThrows(MatrixException.class, () -> m1.multiply(m2));
    }

    static Stream<Arguments> casesMultipleMatrixShouldThrow() {
        return Stream.of(
                Arguments.of(new Matrix(1,1), new Matrix(2,2)),
                Arguments.of(new Matrix(2,1), new Matrix(2,1)),
                Arguments.of(new Matrix(3,5), new Matrix(3,5))
        );
    }

    static Matrix randomInit(Random r,  int rows, int cols) {
        double[][] doubles = new double[rows][];
        for (int i = 0; i < rows; i++) {
            doubles[i] = r.doubles(cols, -25., 25.).toArray();
        }
        return new Matrix(doubles);
    }
}