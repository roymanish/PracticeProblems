
public class TestAnnonymousClass {

	public static void main(String[] args) {
		
		String field3 = "ABC";
		
		String field4 = "DEF";
		
		Object obj = new Object(){
			
			private String field1 = field3;
			
			private String field2 = field4;

			public String getField1() {
				return field1;
			}

			public void setField1(String field1) {
				this.field1 = field1;
			}

			public String getField2() {
				return field2;
			}

			public void setField2(String field2) {
				this.field2 = field2;
			}
			
			@Override
			public String toString() {
				
				return field1+ " "+field2;
			}
		};

		System.out.println(obj);
	}

}
