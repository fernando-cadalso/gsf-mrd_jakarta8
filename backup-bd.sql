PGDMP     6    )                z            gsf_mrd    13.4    13.4     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16384    gsf_mrd    DATABASE     \   CREATE DATABASE gsf_mrd WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'pt_BR.UTF-8';
    DROP DATABASE gsf_mrd;
                postgres    false            �          0    16388    dispensa 
   TABLE DATA           ,   COPY public.dispensa (id, nome) FROM stdin;
    public          fernando    false    201   d       �          0    16396    itemdeconsumo 
   TABLE DATA           o   COPY public.itemdeconsumo (id, descricao, mercado, nome, preco, quantidade, dispensa_id, lista_id) FROM stdin;
    public          fernando    false    203   �       �          0    16455    listadecompra 
   TABLE DATA           1   COPY public.listadecompra (id, data) FROM stdin;
    public          fernando    false    208   �       �          0    16407    listamodelo 
   TABLE DATA           /   COPY public.listamodelo (id, nome) FROM stdin;
    public          fernando    false    205          �          0    16534    listamodelo_listacompras 
   TABLE DATA           V   COPY public.listamodelo_listacompras (listasmodelo_id, listadecompras_id) FROM stdin;
    public          fernando    false    209   W       �          0    16413    morador 
   TABLE DATA           >   COPY public.morador (nome, papel, senha, usuario) FROM stdin;
    public          fernando    false    206   t       �           0    0    dispensa_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.dispensa_id_seq', 3, true);
          public          fernando    false    200            �           0    0    itemdeconsumo_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.itemdeconsumo_id_seq', 23, true);
          public          fernando    false    202            �           0    0    listadecompra_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.listadecompra_id_seq', 1, false);
          public          fernando    false    207            �           0    0    listamodelo_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.listamodelo_id_seq', 6, true);
          public          fernando    false    204            �   1   x�3�t���M�+I<����|.#N����ԼT.cN��܂ԪD�=... 7�m      �   D   x�32���NL:�8_!5W���f�?2�4�22�H槖�B��8M�����.@����<�HC� �@�      �      x������ � �      �   1   x�3�t���M�+I<����|.SN����ԼT.3N��܂ԪD�=... 8�v      �      x������ � �      �      x������ � �     