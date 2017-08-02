package moderjava.edu01;

import moderjava.edu01.vo.AsisLogHistoryVO;
import moderjava.edu01.vo.LogHistoryVO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LearnToEight {

    private static final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    private static final List<String> numbersStr = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

    private static void asisReadFile(){

        try (final FileReader fileReader = new FileReader(new File("/Users/n0roo/myBox/src/fundamental/java8-fundamental/src/moderjava/edu01/test.txt"));
              final BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            final List<String> uniqueWords = new ArrayList<>();
            String line = bufferedReader.readLine();
            while (line != null) {
                final String[] words = line.split("[\\s]+");
                for (final String word : words) {
                    if (!uniqueWords.contains(word)) {
                        uniqueWords.add(word);
                    }
                }
                line = bufferedReader.readLine();
            }
            Collections.sort(uniqueWords);
            System.out.println(uniqueWords);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    private static void tobeReadFile(){
        try (final Stream<String> lines = Files.lines(Paths.get("/Users/n0roo/myBox/src/fundamental/java8-fundamental/src/moderjava/edu01/test.txt"))) {
            System.out.println(
                    lines.map(line -> line.split("[\\s]+"))
                            .flatMap(Arrays::stream)
                            .distinct()
                            .sorted()
                            .collect(toList())
            );
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    private static void asisBuildJoinStr(){

        final StringBuilder sb = new StringBuilder();
        final int size = numbers.size();
        for (int i = 0; i < size; i++) {
            sb.append(numbers.get(i));
            if (i != size - 1) {
                sb.append(" : ");
            }
        }

    /* for-each 사용 */
        final StringBuilder stringBuilder = new StringBuilder();
        final String separator = " : ";
        for (final Integer number : numbers) {
            stringBuilder.append(number).append(separator);
        }
        final int stringLength = stringBuilder.length();
        if (stringLength > 0) {
            stringBuilder.delete(stringLength - separator.length(), stringLength);
        }
        System.out.println(stringBuilder.toString());
    }

    private static void tobeJoinStr(){
        final String result = numbers.stream()
                .map(String::valueOf)
                .collect(joining(" : "));
        System.out.println(result);

        // More Simple
        System.out.println(String.join(" : ",numbersStr));
    }

    private static void parseLoggedAsis(){

        try (final FileReader fileReader = new FileReader(new File("/Users/n0roo/myBox/src/fundamental/java8-fundamental/src/moderjava/edu01/testLog.txt"));
             final BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                Pattern pattern = Pattern.compile("((^\\d{4}\\-0?([1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01]))\\s+((0?[0-9]|[12][0-9])\\:(0?[0-9]|[12345][0-9])\\:(0?[0-9]|[12345][0-9])))\\s+\\|\\s+(SignUp|SignIn|ViewContent|WriteTails|LikeTails|SignOut|WithDrawUser)\\s+\\|\\s+(\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12})\\s+\\|\\s+((user-\\w))$");
                Matcher matcher = pattern.matcher(line);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                if(matcher.matches()){
                    AsisLogHistoryVO asisLogHistoryVO = new AsisLogHistoryVO();
                    for (int i=0; i< matcher.groupCount(); i++){
                        String matchResult = matcher.group(i);
                        if(Pattern.compile("(^\\d{4}\\-0?([1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01]))\\s+((0?[0-9]|[12][0-9])\\:(0?[0-9]|[12345][0-9])\\:(0?[0-9]|[12345][0-9]))").matcher(matchResult).matches()){
                            asisLogHistoryVO.setLoggedAt(sdf.parse(matchResult).getTime());
                        }
                        if(Pattern.compile("(SignUp|SignIn|ViewContent|WriteTails|LikeTails|SignOut|WithDrawUser)").matcher(matchResult).matches()){
                            asisLogHistoryVO.setProcess(AsisLogHistoryVO.PROCESS.valueOf(matchResult.toUpperCase()));
                        }
                        if(Pattern.compile("(\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12})").matcher(matchResult).matches()){
                            asisLogHistoryVO.setUuid(matchResult);
                        }
                        if(Pattern.compile("((user-\\w))$").matcher(matchResult).matches()){
                            asisLogHistoryVO.setUserName(matchResult);
                        }
                    }
                    System.out.println(asisLogHistoryVO.toString());
                }
                line = bufferedReader.readLine();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }


    private static void parseLoggedTobe(){
        try (final Stream<String> lines = Files.lines(Paths.get("/Users/n0roo/myBox/src/fundamental/java8-fundamental/src/moderjava/edu01/testLog.txt"))) {
            Consumer<Matcher> matcherConsumer = (matcher) ->{
                int matchCount=0;
                LogHistoryVO logHistoryVO = new LogHistoryVO();
                while (matcher.matches() && matchCount < matcher.groupCount()){
                    if(Pattern.compile("(^\\d{4}\\-0?([1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01]))\\s+((0?[0-9]|[12][0-9])\\:(0?[0-9]|[12345][0-9])\\:(0?[0-9]|[12345][0-9]))").matcher(matcher.group(matchCount)).matches()) logHistoryVO.setLoggedAt(LocalDateTime.parse(matcher.group(matchCount), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                    if(Pattern.compile("(SignUp|SignIn|ViewContent|WriteTails|LikeTails|SignOut|WithDrawUser)").matcher(matcher.group(matchCount)).matches()) logHistoryVO.setProcess(LogHistoryVO.PROCESS.valueOf(matcher.group(matchCount).toUpperCase()));
                    if(Pattern.compile("(\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12})").matcher(matcher.group(matchCount)).matches()) logHistoryVO.setUuid(matcher.group(matchCount));
                    if(Pattern.compile("((user-\\w))$").matcher(matcher.group(matchCount)).matches()) logHistoryVO.setUserName(matcher.group(matchCount));
                    matchCount++;
                }
                System.out.println(logHistoryVO.toString());
            };

            Pattern pattern = Pattern.compile("((^\\d{4}\\-0?([1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01]))\\s+((0?[0-9]|[12][0-9])\\:(0?[0-9]|[12345][0-9])\\:(0?[0-9]|[12345][0-9])))\\s+\\|\\s+(SignUp|SignIn|ViewContent|WriteTails|LikeTails|SignOut|WithDrawUser)\\s+\\|\\s+(\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12})\\s+\\|\\s+((user-\\w))$");
            lines.map(pattern::matcher)
                    .filter(Matcher::matches)
                    .forEach(matcherConsumer::accept);

            /** More Short
             *
             *
             MatcherConsumer matcherConsumer1 = new MatcherConsumer();
             lines.map(pattern::matcher)
             .filter(Matcher::find)
             .forEach(matcherConsumer1);
             *
             *
             *** */

        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

//    private static class MatcherConsumer implements Consumer<Matcher>{
//
//        @Override
//        public void accept(Matcher matcher) {
//            int matchCount=0;
//            LogHistoryVO logHistoryVO = new LogHistoryVO();
//            while (matcher.matches() && matchCount < matcher.groupCount()){
//                if(Pattern.compile("(^\\d{4}\\-0?([1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01]))\\s+((0?[0-9]|[12][0-9])\\:(0?[0-9]|[12345][0-9])\\:(0?[0-9]|[12345][0-9]))").matcher(matcher.group(matchCount)).matches()) logHistoryVO.setLoggedAt(LocalDateTime.parse(matcher.group(matchCount), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//                if(Pattern.compile("(SignUp|SignIn|ViewContent|WriteTails|LikeTails|SignOut|WithDrawUser)").matcher(matcher.group(matchCount)).matches()) logHistoryVO.setProcess(LogHistoryVO.PROCESS.valueOf(matcher.group(matchCount).toUpperCase()));
//                if(Pattern.compile("(\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12})").matcher(matcher.group(matchCount)).matches()) logHistoryVO.setUuid(matcher.group(matchCount));
//                if(Pattern.compile("((user-\\w))$").matcher(matcher.group(matchCount)).matches()) logHistoryVO.setUserName(matcher.group(matchCount));
//                matchCount++;
//            }
//            System.out.println(logHistoryVO.toString());
//        }
//    }

    public static void main(String [] args){
        asisReadFile();
        tobeReadFile();
        asisBuildJoinStr();
        tobeJoinStr();
        parseLoggedAsis();
        parseLoggedTobe();
    }
}
