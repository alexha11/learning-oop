package a2_2101040197;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * overview PCReport is a  that displays a report of PC objects in tabular format
 * @attributes None
 * objects An array of PC object, objs, where objs[0],...,obj[n-1] are PC objects.
 * @abstract_properties none
 * @author Trong
 */

public class PCReport {
    /**
     * @effects Displays a report of PC objects in tabular format.
     * @param objs An array of PC objects to be displayed in the report.
     * @return A string representation of the report.
     */
    public String displayReport(PC[] objs) {
        //Step 1: Create a 2D array to store the data for the table
        boolean leftJustifiedRows = false;
        String[][] table = new String[objs.length][5];
        int temp = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                for (int k = temp; k < objs.length; k++) {
                    table[i][j] = k + 1 + "";
                    table[i][j + 1] = objs[k].getModel();
                    table[i][j + 2] = String.valueOf(objs[k].getYear());
                    table[i][j + 3] = objs[k].getManufacturer();
                    table[i][j + 4] = objs[k].getComponents().toString();
                    temp += 1;
                    break;
                }
                break;
            }
        }
        // Step2 : Determine the column lengths based on the data in the table
//        Map<Integer, Integer> columlength = new HashMap<>();
//        for (String[] s : table) {
//            Stream.iterate(0, (i -> 1 < s.length), (i -> ++i)).forEach(i -> {
//                switch (i) {
//                    case 0:
//                        columlength.put(i, 3);
//                        break;
//                    case 2:
//                        S.put(i, 6);
//                        break;
//                    case 4:
//                        columlength.put(i, 50);
//                        break;
//                    default:
//                        columlength.put(i, 20);
//                        break;
//                }
//            });
//        }
//        // Step 3: Generate the format string for formatting the table
//            final StringBuilder formatString = new StringBuilder("");
//            String flag = leftJustifiedRows ? "-" : "";
//            columlength.entrySet().stream().forEach(e -> formatString.append(" %" + flag + e.getValue() + "s "));
//            formatString.append("\n");
        // Step 4: Generate the header and footer for the report
            String header = "---------------------------------------------------------------------------------------------------";
            header += String.format("%49s\n", "PCPROG REPORT ");
            header += "---------------------------------------------------------------------------------------------------";
        // Step 5: Generate the content for the report
//            var test = new Object() {
//                String content = "";
//            };
//            Stream.iterate(0, (i -> i < table.length), (i -> ++i)).forEach(a -> test.content += String.format(formatString.toString() + "\n",(Object[]) table[a]));
//            String footer = "---------------------------------------------------------------------------------------------------";
        // Step 6: Combine the header, content, and footer to form the final report
            //return header + test.content + footer;

            return header;
        }
    }

