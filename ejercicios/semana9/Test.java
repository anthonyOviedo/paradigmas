public class Test{
        

        public class  Stack<T>{
                T operate(Operator oper, T v1, T v2){
                       return switch (oper.toString()) {
                                case "-" -> (T) Integer.valueOf(((Integer) v1).intValue() - ((Integer) v2).intValue());
                                default -> throw new UnsupportedOperationException("Unsupported operator: " + oper);
                        };
                }
        }

        record Operator(String name){
                @Override
                public String toString(){
                        return name;
                }
        }

}
