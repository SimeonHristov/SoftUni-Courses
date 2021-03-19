import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//RichSoilLand richSoilLand = new RichSoilLand();

		Field[] declaredFields = RichSoilLand.class.getDeclaredFields();


		String line = "";
		while (!"HARVEST".equals(line = scanner.nextLine())){
			String modifier = line;

			Field[] fields = Arrays.stream(declaredFields)
					.filter(f -> Modifier.toString(f.getModifiers()).equals(modifier))
					.toArray(Field[]::new);

			if (fields.length == 0) {
				printFields(declaredFields);
			} else {
				printFields(fields);
			}

		}




	}

	private static void printFields(Field[] declaredFields) {
		Arrays.stream(declaredFields).forEach(f -> System.out.printf("%s %s %s%n",
				Modifier.toString(f.getModifiers()),
				f.getType().getSimpleName(),
				f.getName()));
	}
}
