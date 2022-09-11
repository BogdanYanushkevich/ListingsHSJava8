#include <jni.h>
#include "NativeDemo.h"
#include <stdio.h>
JNI EXPORT void JNI CALL Java_NativeDemo_test (JNIEnv *env, jobject obj)
{
jclass cls;
jfieldID fid;
jint i;

printf ("Зaпycк платформенно-ориентированного метода.\n ");
cls = (*env)->GetObjectClass(env,obj);
fid = (*env)->GetFieldID(env, cls, "i", "I");
if (fid == 0) {
рrintf( " Невозможно получить поле id.\n");
return;
i ( * env ) ->Ge t in t Fi e ld ( env, obj , fid);
printf("i = %d\n", i);
(*env)->SetIntField(env, obj , fid, 2*i);
рrintf("За вершение платформенно-ориентированного метода. \n")