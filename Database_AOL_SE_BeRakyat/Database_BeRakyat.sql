PGDMP  5                    |            BeRakyat_MainDB    16.2    16.2 �    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16398    BeRakyat_MainDB    DATABASE     �   CREATE DATABASE "BeRakyat_MainDB" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United Kingdom.1252';
 !   DROP DATABASE "BeRakyat_MainDB";
                postgres    false            m           1247    16485    kelamin    TYPE     B   CREATE TYPE public.kelamin AS ENUM (
    'L',
    'P',
    '-'
);
    DROP TYPE public.kelamin;
       public          postgres    false            �           1247    16644 	   keputusan    TYPE     @   CREATE TYPE public.keputusan AS ENUM (
    'Ya',
    'Tidak'
);
    DROP TYPE public.keputusan;
       public          postgres    false            �            1259    16522    admindb    TABLE     #  CREATE TABLE public.admindb (
    adminid integer NOT NULL,
    email character varying(100) NOT NULL,
    adminpassword character varying(100) NOT NULL,
    nama character varying(100) NOT NULL,
    notelpon character varying(100) NOT NULL,
    adminrole character varying(100) NOT NULL
);
    DROP TABLE public.admindb;
       public         heap    postgres    false            �            1259    16521    admindb_adminid_seq    SEQUENCE     �   CREATE SEQUENCE public.admindb_adminid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.admindb_adminid_seq;
       public          postgres    false    221            �           0    0    admindb_adminid_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.admindb_adminid_seq OWNED BY public.admindb.adminid;
          public          postgres    false    220            �            1259    16601    barangdb    TABLE     Y  CREATE TABLE public.barangdb (
    barangid integer NOT NULL,
    jenisbarangid integer NOT NULL,
    sellerid integer NOT NULL,
    nama character varying(100) NOT NULL,
    harga double precision DEFAULT 0.0 NOT NULL,
    berat double precision DEFAULT 0.0 NOT NULL,
    detailbarang character varying(255),
    kuantitas integer DEFAULT 0
);
    DROP TABLE public.barangdb;
       public         heap    postgres    false            �            1259    16598    barangdb_barangid_seq    SEQUENCE     �   CREATE SEQUENCE public.barangdb_barangid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.barangdb_barangid_seq;
       public          postgres    false    227            �           0    0    barangdb_barangid_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.barangdb_barangid_seq OWNED BY public.barangdb.barangid;
          public          postgres    false    224            �            1259    16599    barangdb_jenisbarangid_seq    SEQUENCE     �   CREATE SEQUENCE public.barangdb_jenisbarangid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.barangdb_jenisbarangid_seq;
       public          postgres    false    227            �           0    0    barangdb_jenisbarangid_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.barangdb_jenisbarangid_seq OWNED BY public.barangdb.jenisbarangid;
          public          postgres    false    225            �            1259    16600    barangdb_sellerid_seq    SEQUENCE     �   CREATE SEQUENCE public.barangdb_sellerid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.barangdb_sellerid_seq;
       public          postgres    false    227            �           0    0    barangdb_sellerid_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.barangdb_sellerid_seq OWNED BY public.barangdb.sellerid;
          public          postgres    false    226            �            1259    16652    cartdb    TABLE     !  CREATE TABLE public.cartdb (
    cartid integer NOT NULL,
    userid integer NOT NULL,
    barangid integer NOT NULL,
    hargatotal double precision DEFAULT 0.0 NOT NULL,
    kuantitas integer DEFAULT 0 NOT NULL,
    statusbeli public.keputusan DEFAULT 'Ya'::public.keputusan NOT NULL
);
    DROP TABLE public.cartdb;
       public         heap    postgres    false    898    898            �            1259    16651    cartdb_barangid_seq    SEQUENCE     �   CREATE SEQUENCE public.cartdb_barangid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.cartdb_barangid_seq;
       public          postgres    false    235            �           0    0    cartdb_barangid_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.cartdb_barangid_seq OWNED BY public.cartdb.barangid;
          public          postgres    false    234            �            1259    16649    cartdb_cartid_seq    SEQUENCE     �   CREATE SEQUENCE public.cartdb_cartid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.cartdb_cartid_seq;
       public          postgres    false    235            �           0    0    cartdb_cartid_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.cartdb_cartid_seq OWNED BY public.cartdb.cartid;
          public          postgres    false    232            �            1259    16650    cartdb_userid_seq    SEQUENCE     �   CREATE SEQUENCE public.cartdb_userid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.cartdb_userid_seq;
       public          postgres    false    235            �           0    0    cartdb_userid_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.cartdb_userid_seq OWNED BY public.cartdb.userid;
          public          postgres    false    233            �            1259    16531    jenisbarangdb    TABLE     u   CREATE TABLE public.jenisbarangdb (
    jenisbarangid integer NOT NULL,
    jenis character varying(100) NOT NULL
);
 !   DROP TABLE public.jenisbarangdb;
       public         heap    postgres    false            �            1259    16530    jenisbarangdb_jenisbarangid_seq    SEQUENCE     �   CREATE SEQUENCE public.jenisbarangdb_jenisbarangid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.jenisbarangdb_jenisbarangid_seq;
       public          postgres    false    223            �           0    0    jenisbarangdb_jenisbarangid_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.jenisbarangdb_jenisbarangid_seq OWNED BY public.jenisbarangdb.jenisbarangid;
          public          postgres    false    222            �            1259    16712    orderdb    TABLE       CREATE TABLE public.orderdb (
    orderid integer NOT NULL,
    cartid integer NOT NULL,
    userid integer NOT NULL,
    tanggalpemesanan date NOT NULL,
    alamatpengiriman character varying(100) NOT NULL,
    kuantitasbarangpesan integer DEFAULT 1 NOT NULL
);
    DROP TABLE public.orderdb;
       public         heap    postgres    false            �            1259    16710    orderdb_cartid_seq    SEQUENCE     �   CREATE SEQUENCE public.orderdb_cartid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.orderdb_cartid_seq;
       public          postgres    false    239            �           0    0    orderdb_cartid_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.orderdb_cartid_seq OWNED BY public.orderdb.cartid;
          public          postgres    false    237            �            1259    16709    orderdb_orderid_seq    SEQUENCE     �   CREATE SEQUENCE public.orderdb_orderid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.orderdb_orderid_seq;
       public          postgres    false    239            �           0    0    orderdb_orderid_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.orderdb_orderid_seq OWNED BY public.orderdb.orderid;
          public          postgres    false    236            �            1259    16711    orderdb_userid_seq    SEQUENCE     �   CREATE SEQUENCE public.orderdb_userid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.orderdb_userid_seq;
       public          postgres    false    239            �           0    0    orderdb_userid_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.orderdb_userid_seq OWNED BY public.orderdb.userid;
          public          postgres    false    238            �            1259    16734 	   paymentdb    TABLE       CREATE TABLE public.paymentdb (
    paymentid integer NOT NULL,
    orderid integer NOT NULL,
    userid integer NOT NULL,
    hargaakhir double precision DEFAULT 0.0 NOT NULL,
    tanggalpembayaran date NOT NULL,
    metodepembayaran character varying(100) NOT NULL
);
    DROP TABLE public.paymentdb;
       public         heap    postgres    false            �            1259    16732    paymentdb_orderid_seq    SEQUENCE     �   CREATE SEQUENCE public.paymentdb_orderid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.paymentdb_orderid_seq;
       public          postgres    false    243            �           0    0    paymentdb_orderid_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.paymentdb_orderid_seq OWNED BY public.paymentdb.orderid;
          public          postgres    false    241            �            1259    16731    paymentdb_paymentid_seq    SEQUENCE     �   CREATE SEQUENCE public.paymentdb_paymentid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.paymentdb_paymentid_seq;
       public          postgres    false    243            �           0    0    paymentdb_paymentid_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.paymentdb_paymentid_seq OWNED BY public.paymentdb.paymentid;
          public          postgres    false    240            �            1259    16733    paymentdb_userid_seq    SEQUENCE     �   CREATE SEQUENCE public.paymentdb_userid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.paymentdb_userid_seq;
       public          postgres    false    243            �           0    0    paymentdb_userid_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.paymentdb_userid_seq OWNED BY public.paymentdb.userid;
          public          postgres    false    242            �            1259    16504    sellerdb    TABLE     �  CREATE TABLE public.sellerdb (
    sellerid integer NOT NULL,
    userid integer NOT NULL,
    jumlahbarang integer DEFAULT 0 NOT NULL,
    orderlist character varying(100),
    jumlahtransaksi integer DEFAULT 0,
    namatoko character varying(100) NOT NULL,
    alamattoko character varying(100) NOT NULL,
    notelpon character varying(100) NOT NULL,
    deskripsitoko character varying(255)
);
    DROP TABLE public.sellerdb;
       public         heap    postgres    false            �            1259    16502    sellerdb_sellerid_seq    SEQUENCE     �   CREATE SEQUENCE public.sellerdb_sellerid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.sellerdb_sellerid_seq;
       public          postgres    false    219            �           0    0    sellerdb_sellerid_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.sellerdb_sellerid_seq OWNED BY public.sellerdb.sellerid;
          public          postgres    false    217            �            1259    16503    sellerdb_userid_seq    SEQUENCE     �   CREATE SEQUENCE public.sellerdb_userid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.sellerdb_userid_seq;
       public          postgres    false    219            �           0    0    sellerdb_userid_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.sellerdb_userid_seq OWNED BY public.sellerdb.userid;
          public          postgres    false    218            �            1259    16754 
   shipmentdb    TABLE     �   CREATE TABLE public.shipmentdb (
    shipmentid integer NOT NULL,
    namaarmada character varying(100) NOT NULL,
    alamatarmada character varying(100) NOT NULL,
    tanggalpengiriman date
);
    DROP TABLE public.shipmentdb;
       public         heap    postgres    false            �            1259    16753    shipmentdb_shipmentid_seq    SEQUENCE     �   CREATE SEQUENCE public.shipmentdb_shipmentid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.shipmentdb_shipmentid_seq;
       public          postgres    false    245            �           0    0    shipmentdb_shipmentid_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.shipmentdb_shipmentid_seq OWNED BY public.shipmentdb.shipmentid;
          public          postgres    false    244            �            1259    16767    transactiondb    TABLE     	  CREATE TABLE public.transactiondb (
    transactionid integer NOT NULL,
    adminid integer NOT NULL,
    userid integer NOT NULL,
    sellerid integer NOT NULL,
    paymentid integer NOT NULL,
    shipmentid integer NOT NULL,
    tanggaltransaksi date NOT NULL
);
 !   DROP TABLE public.transactiondb;
       public         heap    postgres    false            �            1259    16762    transactiondb_adminid_seq    SEQUENCE     �   CREATE SEQUENCE public.transactiondb_adminid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.transactiondb_adminid_seq;
       public          postgres    false    252            �           0    0    transactiondb_adminid_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.transactiondb_adminid_seq OWNED BY public.transactiondb.adminid;
          public          postgres    false    247            �            1259    16765    transactiondb_paymentid_seq    SEQUENCE     �   CREATE SEQUENCE public.transactiondb_paymentid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.transactiondb_paymentid_seq;
       public          postgres    false    252            �           0    0    transactiondb_paymentid_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.transactiondb_paymentid_seq OWNED BY public.transactiondb.paymentid;
          public          postgres    false    250            �            1259    16764    transactiondb_sellerid_seq    SEQUENCE     �   CREATE SEQUENCE public.transactiondb_sellerid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.transactiondb_sellerid_seq;
       public          postgres    false    252            �           0    0    transactiondb_sellerid_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.transactiondb_sellerid_seq OWNED BY public.transactiondb.sellerid;
          public          postgres    false    249            �            1259    16766    transactiondb_shipmentid_seq    SEQUENCE     �   CREATE SEQUENCE public.transactiondb_shipmentid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.transactiondb_shipmentid_seq;
       public          postgres    false    252            �           0    0    transactiondb_shipmentid_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.transactiondb_shipmentid_seq OWNED BY public.transactiondb.shipmentid;
          public          postgres    false    251            �            1259    16761    transactiondb_transactionid_seq    SEQUENCE     �   CREATE SEQUENCE public.transactiondb_transactionid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.transactiondb_transactionid_seq;
       public          postgres    false    252            �           0    0    transactiondb_transactionid_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.transactiondb_transactionid_seq OWNED BY public.transactiondb.transactionid;
          public          postgres    false    246            �            1259    16763    transactiondb_userid_seq    SEQUENCE     �   CREATE SEQUENCE public.transactiondb_userid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.transactiondb_userid_seq;
       public          postgres    false    252            �           0    0    transactiondb_userid_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.transactiondb_userid_seq OWNED BY public.transactiondb.userid;
          public          postgres    false    248            �            1259    16492    userdb    TABLE     �  CREATE TABLE public.userdb (
    userid integer NOT NULL,
    nama character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    userpassword character varying(100) NOT NULL,
    notelpon character varying(100) NOT NULL,
    tanggallahir date,
    jeniskelamin public.kelamin DEFAULT '-'::public.kelamin,
    alamat character varying(100) NOT NULL,
    biodata character varying(255),
    saldo double precision DEFAULT 0.0
);
    DROP TABLE public.userdb;
       public         heap    postgres    false    877    877            �            1259    16491    userdb_userid_seq    SEQUENCE     �   CREATE SEQUENCE public.userdb_userid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.userdb_userid_seq;
       public          postgres    false    216            �           0    0    userdb_userid_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.userdb_userid_seq OWNED BY public.userdb.userid;
          public          postgres    false    215            �            1259    16625 
   wishlistdb    TABLE     �   CREATE TABLE public.wishlistdb (
    wishlistid integer NOT NULL,
    userid integer NOT NULL,
    barangid integer NOT NULL,
    tanggalpenambahan date NOT NULL
);
    DROP TABLE public.wishlistdb;
       public         heap    postgres    false            �            1259    16624    wishlistdb_barangid_seq    SEQUENCE     �   CREATE SEQUENCE public.wishlistdb_barangid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.wishlistdb_barangid_seq;
       public          postgres    false    231            �           0    0    wishlistdb_barangid_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.wishlistdb_barangid_seq OWNED BY public.wishlistdb.barangid;
          public          postgres    false    230            �            1259    16623    wishlistdb_userid_seq    SEQUENCE     �   CREATE SEQUENCE public.wishlistdb_userid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.wishlistdb_userid_seq;
       public          postgres    false    231            �           0    0    wishlistdb_userid_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.wishlistdb_userid_seq OWNED BY public.wishlistdb.userid;
          public          postgres    false    229            �            1259    16622    wishlistdb_wishlistid_seq    SEQUENCE     �   CREATE SEQUENCE public.wishlistdb_wishlistid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.wishlistdb_wishlistid_seq;
       public          postgres    false    231            �           0    0    wishlistdb_wishlistid_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.wishlistdb_wishlistid_seq OWNED BY public.wishlistdb.wishlistid;
          public          postgres    false    228            �           2604    16525    admindb adminid    DEFAULT     r   ALTER TABLE ONLY public.admindb ALTER COLUMN adminid SET DEFAULT nextval('public.admindb_adminid_seq'::regclass);
 >   ALTER TABLE public.admindb ALTER COLUMN adminid DROP DEFAULT;
       public          postgres    false    221    220    221            �           2604    16604    barangdb barangid    DEFAULT     v   ALTER TABLE ONLY public.barangdb ALTER COLUMN barangid SET DEFAULT nextval('public.barangdb_barangid_seq'::regclass);
 @   ALTER TABLE public.barangdb ALTER COLUMN barangid DROP DEFAULT;
       public          postgres    false    227    224    227            �           2604    16605    barangdb jenisbarangid    DEFAULT     �   ALTER TABLE ONLY public.barangdb ALTER COLUMN jenisbarangid SET DEFAULT nextval('public.barangdb_jenisbarangid_seq'::regclass);
 E   ALTER TABLE public.barangdb ALTER COLUMN jenisbarangid DROP DEFAULT;
       public          postgres    false    225    227    227            �           2604    16606    barangdb sellerid    DEFAULT     v   ALTER TABLE ONLY public.barangdb ALTER COLUMN sellerid SET DEFAULT nextval('public.barangdb_sellerid_seq'::regclass);
 @   ALTER TABLE public.barangdb ALTER COLUMN sellerid DROP DEFAULT;
       public          postgres    false    226    227    227            �           2604    16655    cartdb cartid    DEFAULT     n   ALTER TABLE ONLY public.cartdb ALTER COLUMN cartid SET DEFAULT nextval('public.cartdb_cartid_seq'::regclass);
 <   ALTER TABLE public.cartdb ALTER COLUMN cartid DROP DEFAULT;
       public          postgres    false    235    232    235            �           2604    16656    cartdb userid    DEFAULT     n   ALTER TABLE ONLY public.cartdb ALTER COLUMN userid SET DEFAULT nextval('public.cartdb_userid_seq'::regclass);
 <   ALTER TABLE public.cartdb ALTER COLUMN userid DROP DEFAULT;
       public          postgres    false    233    235    235            �           2604    16657    cartdb barangid    DEFAULT     r   ALTER TABLE ONLY public.cartdb ALTER COLUMN barangid SET DEFAULT nextval('public.cartdb_barangid_seq'::regclass);
 >   ALTER TABLE public.cartdb ALTER COLUMN barangid DROP DEFAULT;
       public          postgres    false    235    234    235            �           2604    16534    jenisbarangdb jenisbarangid    DEFAULT     �   ALTER TABLE ONLY public.jenisbarangdb ALTER COLUMN jenisbarangid SET DEFAULT nextval('public.jenisbarangdb_jenisbarangid_seq'::regclass);
 J   ALTER TABLE public.jenisbarangdb ALTER COLUMN jenisbarangid DROP DEFAULT;
       public          postgres    false    222    223    223            �           2604    16715    orderdb orderid    DEFAULT     r   ALTER TABLE ONLY public.orderdb ALTER COLUMN orderid SET DEFAULT nextval('public.orderdb_orderid_seq'::regclass);
 >   ALTER TABLE public.orderdb ALTER COLUMN orderid DROP DEFAULT;
       public          postgres    false    236    239    239            �           2604    16716    orderdb cartid    DEFAULT     p   ALTER TABLE ONLY public.orderdb ALTER COLUMN cartid SET DEFAULT nextval('public.orderdb_cartid_seq'::regclass);
 =   ALTER TABLE public.orderdb ALTER COLUMN cartid DROP DEFAULT;
       public          postgres    false    239    237    239            �           2604    16717    orderdb userid    DEFAULT     p   ALTER TABLE ONLY public.orderdb ALTER COLUMN userid SET DEFAULT nextval('public.orderdb_userid_seq'::regclass);
 =   ALTER TABLE public.orderdb ALTER COLUMN userid DROP DEFAULT;
       public          postgres    false    238    239    239            �           2604    16737    paymentdb paymentid    DEFAULT     z   ALTER TABLE ONLY public.paymentdb ALTER COLUMN paymentid SET DEFAULT nextval('public.paymentdb_paymentid_seq'::regclass);
 B   ALTER TABLE public.paymentdb ALTER COLUMN paymentid DROP DEFAULT;
       public          postgres    false    240    243    243            �           2604    16738    paymentdb orderid    DEFAULT     v   ALTER TABLE ONLY public.paymentdb ALTER COLUMN orderid SET DEFAULT nextval('public.paymentdb_orderid_seq'::regclass);
 @   ALTER TABLE public.paymentdb ALTER COLUMN orderid DROP DEFAULT;
       public          postgres    false    243    241    243            �           2604    16739    paymentdb userid    DEFAULT     t   ALTER TABLE ONLY public.paymentdb ALTER COLUMN userid SET DEFAULT nextval('public.paymentdb_userid_seq'::regclass);
 ?   ALTER TABLE public.paymentdb ALTER COLUMN userid DROP DEFAULT;
       public          postgres    false    243    242    243            �           2604    16507    sellerdb sellerid    DEFAULT     v   ALTER TABLE ONLY public.sellerdb ALTER COLUMN sellerid SET DEFAULT nextval('public.sellerdb_sellerid_seq'::regclass);
 @   ALTER TABLE public.sellerdb ALTER COLUMN sellerid DROP DEFAULT;
       public          postgres    false    217    219    219            �           2604    16508    sellerdb userid    DEFAULT     r   ALTER TABLE ONLY public.sellerdb ALTER COLUMN userid SET DEFAULT nextval('public.sellerdb_userid_seq'::regclass);
 >   ALTER TABLE public.sellerdb ALTER COLUMN userid DROP DEFAULT;
       public          postgres    false    218    219    219            �           2604    16757    shipmentdb shipmentid    DEFAULT     ~   ALTER TABLE ONLY public.shipmentdb ALTER COLUMN shipmentid SET DEFAULT nextval('public.shipmentdb_shipmentid_seq'::regclass);
 D   ALTER TABLE public.shipmentdb ALTER COLUMN shipmentid DROP DEFAULT;
       public          postgres    false    245    244    245            �           2604    16770    transactiondb transactionid    DEFAULT     �   ALTER TABLE ONLY public.transactiondb ALTER COLUMN transactionid SET DEFAULT nextval('public.transactiondb_transactionid_seq'::regclass);
 J   ALTER TABLE public.transactiondb ALTER COLUMN transactionid DROP DEFAULT;
       public          postgres    false    246    252    252            �           2604    16771    transactiondb adminid    DEFAULT     ~   ALTER TABLE ONLY public.transactiondb ALTER COLUMN adminid SET DEFAULT nextval('public.transactiondb_adminid_seq'::regclass);
 D   ALTER TABLE public.transactiondb ALTER COLUMN adminid DROP DEFAULT;
       public          postgres    false    252    247    252            �           2604    16772    transactiondb userid    DEFAULT     |   ALTER TABLE ONLY public.transactiondb ALTER COLUMN userid SET DEFAULT nextval('public.transactiondb_userid_seq'::regclass);
 C   ALTER TABLE public.transactiondb ALTER COLUMN userid DROP DEFAULT;
       public          postgres    false    252    248    252            �           2604    16773    transactiondb sellerid    DEFAULT     �   ALTER TABLE ONLY public.transactiondb ALTER COLUMN sellerid SET DEFAULT nextval('public.transactiondb_sellerid_seq'::regclass);
 E   ALTER TABLE public.transactiondb ALTER COLUMN sellerid DROP DEFAULT;
       public          postgres    false    252    249    252            �           2604    16774    transactiondb paymentid    DEFAULT     �   ALTER TABLE ONLY public.transactiondb ALTER COLUMN paymentid SET DEFAULT nextval('public.transactiondb_paymentid_seq'::regclass);
 F   ALTER TABLE public.transactiondb ALTER COLUMN paymentid DROP DEFAULT;
       public          postgres    false    252    250    252            �           2604    16775    transactiondb shipmentid    DEFAULT     �   ALTER TABLE ONLY public.transactiondb ALTER COLUMN shipmentid SET DEFAULT nextval('public.transactiondb_shipmentid_seq'::regclass);
 G   ALTER TABLE public.transactiondb ALTER COLUMN shipmentid DROP DEFAULT;
       public          postgres    false    252    251    252            �           2604    16495    userdb userid    DEFAULT     n   ALTER TABLE ONLY public.userdb ALTER COLUMN userid SET DEFAULT nextval('public.userdb_userid_seq'::regclass);
 <   ALTER TABLE public.userdb ALTER COLUMN userid DROP DEFAULT;
       public          postgres    false    216    215    216            �           2604    16628    wishlistdb wishlistid    DEFAULT     ~   ALTER TABLE ONLY public.wishlistdb ALTER COLUMN wishlistid SET DEFAULT nextval('public.wishlistdb_wishlistid_seq'::regclass);
 D   ALTER TABLE public.wishlistdb ALTER COLUMN wishlistid DROP DEFAULT;
       public          postgres    false    231    228    231            �           2604    16629    wishlistdb userid    DEFAULT     v   ALTER TABLE ONLY public.wishlistdb ALTER COLUMN userid SET DEFAULT nextval('public.wishlistdb_userid_seq'::regclass);
 @   ALTER TABLE public.wishlistdb ALTER COLUMN userid DROP DEFAULT;
       public          postgres    false    229    231    231            �           2604    16630    wishlistdb barangid    DEFAULT     z   ALTER TABLE ONLY public.wishlistdb ALTER COLUMN barangid SET DEFAULT nextval('public.wishlistdb_barangid_seq'::regclass);
 B   ALTER TABLE public.wishlistdb ALTER COLUMN barangid DROP DEFAULT;
       public          postgres    false    230    231    231            z          0    16522    admindb 
   TABLE DATA           [   COPY public.admindb (adminid, email, adminpassword, nama, notelpon, adminrole) FROM stdin;
    public          postgres    false    221   �       �          0    16601    barangdb 
   TABLE DATA           r   COPY public.barangdb (barangid, jenisbarangid, sellerid, nama, harga, berat, detailbarang, kuantitas) FROM stdin;
    public          postgres    false    227   7�       �          0    16652    cartdb 
   TABLE DATA           ]   COPY public.cartdb (cartid, userid, barangid, hargatotal, kuantitas, statusbeli) FROM stdin;
    public          postgres    false    235   T�       |          0    16531    jenisbarangdb 
   TABLE DATA           =   COPY public.jenisbarangdb (jenisbarangid, jenis) FROM stdin;
    public          postgres    false    223   q�       �          0    16712    orderdb 
   TABLE DATA           t   COPY public.orderdb (orderid, cartid, userid, tanggalpemesanan, alamatpengiriman, kuantitasbarangpesan) FROM stdin;
    public          postgres    false    239   ��       �          0    16734 	   paymentdb 
   TABLE DATA           p   COPY public.paymentdb (paymentid, orderid, userid, hargaakhir, tanggalpembayaran, metodepembayaran) FROM stdin;
    public          postgres    false    243   ��       x          0    16504    sellerdb 
   TABLE DATA           �   COPY public.sellerdb (sellerid, userid, jumlahbarang, orderlist, jumlahtransaksi, namatoko, alamattoko, notelpon, deskripsitoko) FROM stdin;
    public          postgres    false    219   ��       �          0    16754 
   shipmentdb 
   TABLE DATA           ]   COPY public.shipmentdb (shipmentid, namaarmada, alamatarmada, tanggalpengiriman) FROM stdin;
    public          postgres    false    245   !�       �          0    16767    transactiondb 
   TABLE DATA           z   COPY public.transactiondb (transactionid, adminid, userid, sellerid, paymentid, shipmentid, tanggaltransaksi) FROM stdin;
    public          postgres    false    252   >�       u          0    16492    userdb 
   TABLE DATA           �   COPY public.userdb (userid, nama, email, userpassword, notelpon, tanggallahir, jeniskelamin, alamat, biodata, saldo) FROM stdin;
    public          postgres    false    216   [�       �          0    16625 
   wishlistdb 
   TABLE DATA           U   COPY public.wishlistdb (wishlistid, userid, barangid, tanggalpenambahan) FROM stdin;
    public          postgres    false    231   ��       �           0    0    admindb_adminid_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.admindb_adminid_seq', 1, false);
          public          postgres    false    220            �           0    0    barangdb_barangid_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.barangdb_barangid_seq', 1, false);
          public          postgres    false    224            �           0    0    barangdb_jenisbarangid_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.barangdb_jenisbarangid_seq', 1, false);
          public          postgres    false    225            �           0    0    barangdb_sellerid_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.barangdb_sellerid_seq', 1, false);
          public          postgres    false    226            �           0    0    cartdb_barangid_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.cartdb_barangid_seq', 1, false);
          public          postgres    false    234            �           0    0    cartdb_cartid_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.cartdb_cartid_seq', 1, false);
          public          postgres    false    232            �           0    0    cartdb_userid_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.cartdb_userid_seq', 1, false);
          public          postgres    false    233            �           0    0    jenisbarangdb_jenisbarangid_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.jenisbarangdb_jenisbarangid_seq', 1, false);
          public          postgres    false    222            �           0    0    orderdb_cartid_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.orderdb_cartid_seq', 1, false);
          public          postgres    false    237            �           0    0    orderdb_orderid_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.orderdb_orderid_seq', 1, false);
          public          postgres    false    236            �           0    0    orderdb_userid_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.orderdb_userid_seq', 1, false);
          public          postgres    false    238            �           0    0    paymentdb_orderid_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.paymentdb_orderid_seq', 1, false);
          public          postgres    false    241            �           0    0    paymentdb_paymentid_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.paymentdb_paymentid_seq', 1, false);
          public          postgres    false    240            �           0    0    paymentdb_userid_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.paymentdb_userid_seq', 1, false);
          public          postgres    false    242            �           0    0    sellerdb_sellerid_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.sellerdb_sellerid_seq', 1, true);
          public          postgres    false    217            �           0    0    sellerdb_userid_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.sellerdb_userid_seq', 1, false);
          public          postgres    false    218            �           0    0    shipmentdb_shipmentid_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.shipmentdb_shipmentid_seq', 1, false);
          public          postgres    false    244            �           0    0    transactiondb_adminid_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.transactiondb_adminid_seq', 1, false);
          public          postgres    false    247            �           0    0    transactiondb_paymentid_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.transactiondb_paymentid_seq', 1, false);
          public          postgres    false    250            �           0    0    transactiondb_sellerid_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.transactiondb_sellerid_seq', 1, false);
          public          postgres    false    249            �           0    0    transactiondb_shipmentid_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.transactiondb_shipmentid_seq', 1, false);
          public          postgres    false    251            �           0    0    transactiondb_transactionid_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.transactiondb_transactionid_seq', 1, false);
          public          postgres    false    246            �           0    0    transactiondb_userid_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.transactiondb_userid_seq', 1, false);
          public          postgres    false    248            �           0    0    userdb_userid_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.userdb_userid_seq', 1, true);
          public          postgres    false    215            �           0    0    wishlistdb_barangid_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.wishlistdb_barangid_seq', 1, false);
          public          postgres    false    230            �           0    0    wishlistdb_userid_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.wishlistdb_userid_seq', 1, false);
          public          postgres    false    229            �           0    0    wishlistdb_wishlistid_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.wishlistdb_wishlistid_seq', 1, false);
          public          postgres    false    228            �           2606    16529    admindb admindb_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.admindb
    ADD CONSTRAINT admindb_pkey PRIMARY KEY (adminid);
 >   ALTER TABLE ONLY public.admindb DROP CONSTRAINT admindb_pkey;
       public            postgres    false    221            �           2606    16611    barangdb barangdb_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.barangdb
    ADD CONSTRAINT barangdb_pkey PRIMARY KEY (barangid);
 @   ALTER TABLE ONLY public.barangdb DROP CONSTRAINT barangdb_pkey;
       public            postgres    false    227            �           2606    16662    cartdb cartdb_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.cartdb
    ADD CONSTRAINT cartdb_pkey PRIMARY KEY (cartid);
 <   ALTER TABLE ONLY public.cartdb DROP CONSTRAINT cartdb_pkey;
       public            postgres    false    235            �           2606    16536     jenisbarangdb jenisbarangdb_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY public.jenisbarangdb
    ADD CONSTRAINT jenisbarangdb_pkey PRIMARY KEY (jenisbarangid);
 J   ALTER TABLE ONLY public.jenisbarangdb DROP CONSTRAINT jenisbarangdb_pkey;
       public            postgres    false    223            �           2606    16720    orderdb orderdb_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.orderdb
    ADD CONSTRAINT orderdb_pkey PRIMARY KEY (orderid);
 >   ALTER TABLE ONLY public.orderdb DROP CONSTRAINT orderdb_pkey;
       public            postgres    false    239            �           2606    16742    paymentdb paymentdb_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.paymentdb
    ADD CONSTRAINT paymentdb_pkey PRIMARY KEY (paymentid);
 B   ALTER TABLE ONLY public.paymentdb DROP CONSTRAINT paymentdb_pkey;
       public            postgres    false    243            �           2606    16514    sellerdb sellerdb_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.sellerdb
    ADD CONSTRAINT sellerdb_pkey PRIMARY KEY (sellerid);
 @   ALTER TABLE ONLY public.sellerdb DROP CONSTRAINT sellerdb_pkey;
       public            postgres    false    219            �           2606    16759    shipmentdb shipmentdb_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.shipmentdb
    ADD CONSTRAINT shipmentdb_pkey PRIMARY KEY (shipmentid);
 D   ALTER TABLE ONLY public.shipmentdb DROP CONSTRAINT shipmentdb_pkey;
       public            postgres    false    245            �           2606    16777     transactiondb transactiondb_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY public.transactiondb
    ADD CONSTRAINT transactiondb_pkey PRIMARY KEY (transactionid);
 J   ALTER TABLE ONLY public.transactiondb DROP CONSTRAINT transactiondb_pkey;
       public            postgres    false    252            �           2606    16501    userdb userdb_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.userdb
    ADD CONSTRAINT userdb_pkey PRIMARY KEY (userid);
 <   ALTER TABLE ONLY public.userdb DROP CONSTRAINT userdb_pkey;
       public            postgres    false    216            �           2606    16632    wishlistdb wishlistdb_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.wishlistdb
    ADD CONSTRAINT wishlistdb_pkey PRIMARY KEY (wishlistid);
 D   ALTER TABLE ONLY public.wishlistdb DROP CONSTRAINT wishlistdb_pkey;
       public            postgres    false    231            �           2606    16612    barangdb fk_barang_jenisbarang    FK CONSTRAINT     �   ALTER TABLE ONLY public.barangdb
    ADD CONSTRAINT fk_barang_jenisbarang FOREIGN KEY (jenisbarangid) REFERENCES public.jenisbarangdb(jenisbarangid);
 H   ALTER TABLE ONLY public.barangdb DROP CONSTRAINT fk_barang_jenisbarang;
       public          postgres    false    227    223    4806            �           2606    16617    barangdb fk_barang_seller    FK CONSTRAINT     �   ALTER TABLE ONLY public.barangdb
    ADD CONSTRAINT fk_barang_seller FOREIGN KEY (sellerid) REFERENCES public.sellerdb(sellerid);
 C   ALTER TABLE ONLY public.barangdb DROP CONSTRAINT fk_barang_seller;
       public          postgres    false    4802    219    227            �           2606    16668    cartdb fk_cart_barang    FK CONSTRAINT     ~   ALTER TABLE ONLY public.cartdb
    ADD CONSTRAINT fk_cart_barang FOREIGN KEY (barangid) REFERENCES public.barangdb(barangid);
 ?   ALTER TABLE ONLY public.cartdb DROP CONSTRAINT fk_cart_barang;
       public          postgres    false    235    227    4808            �           2606    16663    cartdb fk_cart_user    FK CONSTRAINT     v   ALTER TABLE ONLY public.cartdb
    ADD CONSTRAINT fk_cart_user FOREIGN KEY (userid) REFERENCES public.userdb(userid);
 =   ALTER TABLE ONLY public.cartdb DROP CONSTRAINT fk_cart_user;
       public          postgres    false    4800    216    235            �           2606    16726    orderdb fk_order_card    FK CONSTRAINT     x   ALTER TABLE ONLY public.orderdb
    ADD CONSTRAINT fk_order_card FOREIGN KEY (cartid) REFERENCES public.cartdb(cartid);
 ?   ALTER TABLE ONLY public.orderdb DROP CONSTRAINT fk_order_card;
       public          postgres    false    235    4812    239            �           2606    16721    orderdb fk_order_user    FK CONSTRAINT     x   ALTER TABLE ONLY public.orderdb
    ADD CONSTRAINT fk_order_user FOREIGN KEY (userid) REFERENCES public.userdb(userid);
 ?   ALTER TABLE ONLY public.orderdb DROP CONSTRAINT fk_order_user;
       public          postgres    false    4800    239    216            �           2606    16748    paymentdb fk_payment_order    FK CONSTRAINT     �   ALTER TABLE ONLY public.paymentdb
    ADD CONSTRAINT fk_payment_order FOREIGN KEY (orderid) REFERENCES public.orderdb(orderid);
 D   ALTER TABLE ONLY public.paymentdb DROP CONSTRAINT fk_payment_order;
       public          postgres    false    239    4814    243            �           2606    16743    paymentdb fk_payment_user    FK CONSTRAINT     |   ALTER TABLE ONLY public.paymentdb
    ADD CONSTRAINT fk_payment_user FOREIGN KEY (userid) REFERENCES public.userdb(userid);
 C   ALTER TABLE ONLY public.paymentdb DROP CONSTRAINT fk_payment_user;
       public          postgres    false    243    216    4800            �           2606    16515    sellerdb fk_seller    FK CONSTRAINT     u   ALTER TABLE ONLY public.sellerdb
    ADD CONSTRAINT fk_seller FOREIGN KEY (userid) REFERENCES public.userdb(userid);
 <   ALTER TABLE ONLY public.sellerdb DROP CONSTRAINT fk_seller;
       public          postgres    false    219    216    4800            �           2606    16778 "   transactiondb fk_transaction_admin    FK CONSTRAINT     �   ALTER TABLE ONLY public.transactiondb
    ADD CONSTRAINT fk_transaction_admin FOREIGN KEY (adminid) REFERENCES public.admindb(adminid);
 L   ALTER TABLE ONLY public.transactiondb DROP CONSTRAINT fk_transaction_admin;
       public          postgres    false    252    4804    221            �           2606    16793 $   transactiondb fk_transaction_payment    FK CONSTRAINT     �   ALTER TABLE ONLY public.transactiondb
    ADD CONSTRAINT fk_transaction_payment FOREIGN KEY (paymentid) REFERENCES public.paymentdb(paymentid);
 N   ALTER TABLE ONLY public.transactiondb DROP CONSTRAINT fk_transaction_payment;
       public          postgres    false    243    4816    252            �           2606    16788 #   transactiondb fk_transaction_seller    FK CONSTRAINT     �   ALTER TABLE ONLY public.transactiondb
    ADD CONSTRAINT fk_transaction_seller FOREIGN KEY (sellerid) REFERENCES public.sellerdb(sellerid);
 M   ALTER TABLE ONLY public.transactiondb DROP CONSTRAINT fk_transaction_seller;
       public          postgres    false    252    219    4802            �           2606    16798 %   transactiondb fk_transaction_shipment    FK CONSTRAINT     �   ALTER TABLE ONLY public.transactiondb
    ADD CONSTRAINT fk_transaction_shipment FOREIGN KEY (shipmentid) REFERENCES public.shipmentdb(shipmentid);
 O   ALTER TABLE ONLY public.transactiondb DROP CONSTRAINT fk_transaction_shipment;
       public          postgres    false    252    245    4818            �           2606    16783 !   transactiondb fk_transaction_user    FK CONSTRAINT     �   ALTER TABLE ONLY public.transactiondb
    ADD CONSTRAINT fk_transaction_user FOREIGN KEY (userid) REFERENCES public.userdb(userid);
 K   ALTER TABLE ONLY public.transactiondb DROP CONSTRAINT fk_transaction_user;
       public          postgres    false    216    252    4800            �           2606    16638    wishlistdb fk_wishlist_barang    FK CONSTRAINT     �   ALTER TABLE ONLY public.wishlistdb
    ADD CONSTRAINT fk_wishlist_barang FOREIGN KEY (barangid) REFERENCES public.barangdb(barangid);
 G   ALTER TABLE ONLY public.wishlistdb DROP CONSTRAINT fk_wishlist_barang;
       public          postgres    false    227    231    4808            �           2606    16633    wishlistdb fk_wishlist_user    FK CONSTRAINT     ~   ALTER TABLE ONLY public.wishlistdb
    ADD CONSTRAINT fk_wishlist_user FOREIGN KEY (userid) REFERENCES public.userdb(userid);
 E   ALTER TABLE ONLY public.wishlistdb DROP CONSTRAINT fk_wishlist_user;
       public          postgres    false    4800    231    216            z      x������ � �      �      x������ � �      �      x������ � �      |      x������ � �      �      x������ � �      �      x������ � �      x   I   x�3�4�4���/��K2<�J�K8݋�R�s+*��9-9C�󁼜D�Ă����R�=... ���      �      x������ � �      �      x������ � �      u   b   x�3�tK,�H���,�LL�Ls�s3s���s9����9,,,----���8-MLu,t�9}8݋�R�s+*9�K���S9�b���� >�7      �      x������ � �     