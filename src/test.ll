declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strs = constant [3 x i8] c"%d\00"
define i32 @main() nounwind{
%a = alloca i32
%1 = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strs, i32 0, i32 0), i32* %a)
%2 = alloca i32
store i32 0, i32* %2
br label %cond1
cond1:
%3 = load i32, i32* %2
%4 = add i32 %3, 1
store i32 %4, i32* %2
%5 = icmp slt i32 %3, 3
br i1 %5, label %true1, label %false1
true1:
%6 = load i32, i32* %a
%7 = alloca i32
store i32 0, i32* %7
br label %cond2
cond2:
%8 = load i32, i32* %7
%9 = add i32 %8, 1
store i32 %9, i32* %7
%10 = icmp slt i32 %8, %6
br i1 %10, label %true2, label %false2
true2:
%11 = load i32, i32* %a
%12 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %11)
br label %cond2
false2:
br label %cond1
false1:
ret i32 0 }

