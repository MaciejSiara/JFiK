import java.util.Stack;

class LLVMGenerator {

    static String header_text = "";
    static String main_text = "";
    static int reg = 1;
    static int br = 0;

    static Stack<Integer> brstack = new Stack<Integer>();

    //BLOCK
    static void repeatstart(String repetitions){
        declare_i32(Integer.toString(reg));
        int counter = reg;
        reg++;
        assign_i32(Integer.toString(counter), "0");
        br++;
        main_text += "br label %cond"+br+"\n";
        main_text += "cond"+br+":\n";

        load_i32(Integer.toString(counter));
        add_i32("%"+(reg-1), "1");
        assign_i32(Integer.toString(counter), "%"+(reg-1));

        main_text += "%"+reg+" = icmp slt i32 %"+(reg-2)+", "+repetitions+"\n";
        reg++;

        main_text += "br i1 %"+(reg-1)+", label %true"+br+", label %false"+br+"\n";
        main_text += "true"+br+":\n";
        brstack.push(br);
    }

    static void repeatend(){
        int b = brstack.pop();
        main_text += "br label %cond"+b+"\n";
        main_text += "false"+b+":\n";
    }

    static void printf_i32(String id){
        main_text += "%"+reg+" = load i32, i32* %"+id+"\n";
        reg++;
        main_text += "%"+reg+" = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %"+(reg-1)+")\n";
        reg++;
    }

    static void printf_double(String id){
        main_text += "%"+reg+" = load double, double* %"+id+"\n";
        reg++;
        main_text += "%"+reg+" = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %"+(reg-1)+")\n";
        reg++;
    }

    static void scanf(String id){

        main_text += "%" + reg + " = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strs, i32 0, i32 0), i32* %"+(id)+ ")\n";
        reg++;
    }

    static void declare_i32(String id){
        main_text += "%"+id+" = alloca i32\n";
    }

    static void declare_double(String id){
        main_text += "%"+id+" = alloca double\n";
    }

    static void assign_i32(String id, String value){
        main_text += "store i32 "+value+", i32* %"+id+"\n";
    }

    static void assign_double(String id, String value){
        main_text += "store double "+value+", double* %"+id+"\n";
    }


    static void load_i32(String id){
        main_text += "%"+reg+" = load i32, i32* %"+id+"\n";
        reg++;
    }

    static void load_double(String id){
        main_text += "%"+reg+" = load double, double* %"+id+"\n";
        reg++;
    }

    static void add_i32(String val1, String val2){
        main_text += "%"+reg+" = add i32 "+val1+", "+val2+"\n";
        reg++;
    }

    static void add_i32_var(String id, String val2){
        load_i32(id);
        main_text += "%"+reg+" = add i32 "+val2+", %"+(reg-1)+"\n";
        reg++;
    }

    static void add_vars_i32(String id1, String id2){
        load_i32(id1);
        load_i32(id2);
        main_text += "%"+reg+" = add i32 %"+(reg-1)+", %"+(reg-2)+"\n";
        reg++;
    }

    static void add_vars_double(String id1, String id2){
        load_double(id1);
        load_double(id2);
        main_text += "%"+reg+" = fadd double %"+(reg-1)+", %"+(reg-2)+"\n";
        reg++;
    }

    static void add_double_var(String id, String val2){
        load_double(id);
        main_text += "%"+reg+" = fadd double "+val2+", %"+(reg-1)+"\n";
        reg++;
    }

    static void add_double(String val1, String val2){
        main_text += "%"+reg+" = fadd double "+val1+", "+val2+"\n";
        reg++;
    }

    static void sub_i32(String val1, String val2){
        main_text += "%"+reg+" = sub i32 "+val1+", "+val2+"\n";
        reg++;
    }

    static void sub_i32_var(String id, String val2, int variant){
        load_i32(id);
        if(variant == 0){
            main_text += "%"+reg+" = sub i32 "+val2+",%"+(reg-1)+" \n";
        }else {
            main_text += "%"+reg+" = sub i32 %"+(reg-1)+","+val2+" \n";
        }
        reg++;
    }

    static void sub_double(String val1, String val2){
        main_text += "%"+reg+" = fsub double "+val1+", "+val2+"\n";
        reg++;
    }

    static void sub_double_var(String id, String val2, int variant){
        load_double(id);
        if(variant == 0){
            main_text += "%"+reg+" = fsub double "+val2+",%"+(reg-1)+" \n";
        }else {
            main_text += "%"+reg+" = fsub double %"+(reg-1)+","+val2+" \n";
        }
        reg++;
    }

    static void sub_vars_i32(String id1, String id2){
        load_i32(id1);
        load_i32(id2);
        main_text += "%"+reg+" = sub i32 %"+(reg-1)+", %"+(reg-2)+"\n";
        reg++;
    }

    static void sub_vars_double(String id1, String id2){
        load_double(id1);
        load_double(id2);
        main_text += "%"+reg+" = fsub double %"+(reg-1)+", %"+(reg-2)+"\n";
        reg++;
    }

    static void mul_i32(String val1, String val2){
        main_text += "%"+reg+" = mul i32 "+val1+", "+val2+"\n";
        reg++;
    }

    static void mul_double(String val1, String val2){
        main_text += "%"+reg+" = fmul double "+val1+", "+val2+"\n";
        reg++;
    }

    static void div_i32(String val1, String val2){
        main_text += "%"+reg+" = udiv i32 "+val2+", "+val1+"\n";
        reg++;
    }

    static void div_double(String val1, String val2){
        main_text += "%"+reg+" = fdiv double "+val2+", "+val1+"\n";
        reg++;
    }

    static void sitofp(String id){
        main_text += "%"+reg+" = sitofp i32 "+id+" to double\n";
        reg++;
    }

    static void sitofp_var(String id){
        load_i32(id);
        main_text += "%"+reg+" = sitofp i32 %"+(reg-1)+" to double\n";
        reg++;
    }


    static void fptosi(String id){
        main_text += "%"+reg+" = fptosi double "+id+" to i32\n";
        reg++;
    }

    static void fptosi_var(String id){
        load_double(id);
        main_text += "%"+reg+" = fptosi double %"+(reg-1)+" to i32\n";
        reg++;
    }





    static String generate(){
        String text = "";
        text += "declare i32 @printf(i8*, ...)\n";
        text += "declare i32 @scanf(i8*, ...)\n";
        text += "@strpi = constant [4 x i8] c\"%d\\0A\\00\"\n";
        text += "@strpd = constant [4 x i8] c\"%f\\0A\\00\"\n";
        text += "@strs = constant [3 x i8] c\"%d\\00\"\n";
        text += header_text;
        text += "define i32 @main() nounwind{\n";
        text += main_text;
        text += "ret i32 0 }\n";
        return text;
    }

}



