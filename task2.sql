PGDMP     '                      {            task2    15.1    15.1     ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    17138    task2    DATABASE     ?   CREATE DATABASE task2 WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE task2;
                postgres    false            ?            1259    17150    task    TABLE     ?   CREATE TABLE public.task (
    id integer NOT NULL,
    title character varying(255) NOT NULL,
    description character varying(255) NOT NULL,
    completed character varying(255) NOT NULL
);
    DROP TABLE public.task;
       public         heap    postgres    false            ?            1259    17149    task_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.task_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.task_id_seq;
       public          postgres    false    215            ?           0    0    task_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.task_id_seq OWNED BY public.task.id;
          public          postgres    false    214            e           2604    17153    task id    DEFAULT     b   ALTER TABLE ONLY public.task ALTER COLUMN id SET DEFAULT nextval('public.task_id_seq'::regclass);
 6   ALTER TABLE public.task ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    214    215    215            ?          0    17150    task 
   TABLE DATA           A   COPY public.task (id, title, description, completed) FROM stdin;
    public          postgres    false    215   s
       ?           0    0    task_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.task_id_seq', 4, true);
          public          postgres    false    214            g           2606    17157    task task_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.task
    ADD CONSTRAINT task_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.task DROP CONSTRAINT task_pkey;
       public            postgres    false    215            ?   R   x?3??IM,?S???2??J?J?SA? faijQ?B?BJbIbRbq*gIQi*?	gbNAFbRj	gbR2gZbNq*W? ???     